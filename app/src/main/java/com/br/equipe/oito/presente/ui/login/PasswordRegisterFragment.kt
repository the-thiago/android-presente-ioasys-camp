package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentPasswordRegisterBinding
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel
import java.util.*

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
            binding.etPasswordRegister.setText(it.password)
        }
    }

    private fun isValidPassword(password: String): Boolean {
        val specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}"
        var hasSpecialCharacters = false
        password.forEach { char ->
            if (specialCharactersString.contains(char)) {
                hasSpecialCharacters = true
                return@forEach
            }
        }
        if (password.length < 7 || password == password.toLowerCase(Locale.ROOT) || !hasSpecialCharacters) {
            binding.ilPasswordRegister.error = "Ao menos 7 caracteres, 1 maiúsculo e 1 especial"
            Toast.makeText(
                requireContext(),
                "Senha não atende aos requesitos mínimos!",
                Toast.LENGTH_LONG
            ).show()
            return false
        }
        return true
    }

    private fun initListener() {
        binding.btnContinuePassword.setOnClickListener {
            val password = binding.etPasswordRegister.text.toString()
            if (isValidPassword(password)) {
                binding.ilPasswordRegister.error = null
                userViewModel.updatePassword(password)
                findNavController().navigate(PasswordRegisterFragmentDirections.actionPasswordRegisterFragmentToCepRegisterFragment())
            }
        }
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}