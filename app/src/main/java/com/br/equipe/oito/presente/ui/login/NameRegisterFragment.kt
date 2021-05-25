package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentNameRegisterBinding
import com.br.equipe.oito.presente.ui.login.typeofuser.ChooseTypeOfUserFragment.Companion.COMPANY_TYPE
import com.br.equipe.oito.presente.ui.login.typeofuser.ChooseTypeOfUserFragment.Companion.TUTOR_TYPE
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel

class NameRegisterFragment : Fragment() {

    private var _binding: FragmentNameRegisterBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNameRegisterBinding.inflate(inflater, container, false)
        val model = ViewModelProvider(requireActivity()).get(NewUserViewModel::class.java)
        if (model.typeOfUser.value == COMPANY_TYPE) {
            binding.tvWhatsYourName.text = "Qual o nome da empresa?"
            binding.etName.hint = "Apperture Science INC."
        }
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
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.btnContinueEmail.setOnClickListener {
            binding.progressBar.apply {
                val model = ViewModelProvider(requireActivity()).get(NewUserViewModel::class.java)
                if (model.typeOfUser.value == TUTOR_TYPE) {
                    findNavController().navigate(NameRegisterFragmentDirections.actionNameRegisterFragmentToCompanyFragment())
                } else {
                    findNavController().navigate(NameRegisterFragmentDirections.actionNameRegisterFragmentToEmailRegisterFragment())
                }
            }
        }
    }

}