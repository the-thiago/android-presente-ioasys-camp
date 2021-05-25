package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentPasswordRegisterBinding
import com.br.equipe.oito.presente.ui.login.typeofuser.ChooseTypeOfUserFragment
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel

class PasswordRegisterFragment : Fragment() {

    private var _binding: FragmentPasswordRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPasswordRegisterBinding.inflate(inflater, container, false)
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
        binding.btnContinuePassword.setOnClickListener {
            val model = ViewModelProvider(requireActivity()).get(NewUserViewModel::class.java)
            if (model.typeOfUser.value == ChooseTypeOfUserFragment.COMPANY_TYPE) {
                findNavController().navigate(PasswordRegisterFragmentDirections.actionPasswordRegisterFragmentToNumberOfEmployeesFragment())
            } else {
                findNavController().navigate(PasswordRegisterFragmentDirections.actionPasswordRegisterFragmentToCepRegisterFragment())
            }
        }
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}