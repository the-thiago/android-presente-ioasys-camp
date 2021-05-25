package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentCepRegisterBinding
import com.br.equipe.oito.presente.ui.login.typeofuser.ChooseTypeOfUserFragment.Companion.TUTOR_TYPE
import com.br.equipe.oito.presente.util.Mask
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel

class CepRegisterFragment : Fragment() {

    private var _binding: FragmentCepRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCepRegisterBinding.inflate(inflater, container, false)
        val model = ViewModelProvider(requireActivity()).get(NewUserViewModel::class.java)
        if (model.typeOfUser.value == TUTOR_TYPE) binding.progressBar.progress = 65
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.etCep.addTextChangedListener(Mask.insert(Mask.FORMAT_CEP, binding.etCep))
        binding.btnContinueCep.setOnClickListener {
            val model = ViewModelProvider(requireActivity()).get(NewUserViewModel::class.java)
            if (model.typeOfUser.value == TUTOR_TYPE) {
                findNavController().navigate(CepRegisterFragmentDirections.actionCepRegisterFragmentToEducationFragment())
            } else {
                findNavController().navigate(CepRegisterFragmentDirections.actionCepRegisterFragmentToGenderFragment())
            }
        }
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}