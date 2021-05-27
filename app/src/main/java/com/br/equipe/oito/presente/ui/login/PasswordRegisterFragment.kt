package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentPasswordRegisterBinding
import com.br.equipe.oito.presente.ui.login.typeofuser.ChooseTypeOfUserFragment
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel

class PasswordRegisterFragment : Fragment() {

    private var _binding: FragmentPasswordRegisterBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: NewUserViewModel by activityViewModels()

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
        initObserver()
        initListener()
    }

    private fun initObserver() {
        userViewModel.user.observe(viewLifecycleOwner) {
            when (it.password) {
                "invalid" -> {
                    Toast.makeText(
                        requireContext(),
                        "Senha não atende aos requesitos mínimos!",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else -> {
                    findNavController().navigate(PasswordRegisterFragmentDirections.actionPasswordRegisterFragmentToCepRegisterFragment())
                }
            }
        }
    }

    private fun initListener() {
        binding.btnContinuePassword.setOnClickListener {
            userViewModel.updatePassword(binding.etPasswordRegister.text.toString())
//            val model = ViewModelProvider(requireActivity()).get(NewUserViewModel::class.java)
//            if (model.typeOfUser.value == ChooseTypeOfUserFragment.COMPANY_TYPE) {
//                findNavController().navigate(PasswordRegisterFragmentDirections.actionPasswordRegisterFragmentToNumberOfEmployeesFragment())
//            } else {
//                findNavController().navigate(PasswordRegisterFragmentDirections.actionPasswordRegisterFragmentToCepRegisterFragment())
//            }
        }
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}