package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentEmailRegisterBinding
import com.br.equipe.oito.presente.util.isEmailValid
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel

class EmailRegisterFragment : Fragment() {

    companion object {
        const val TAG = "EmailRegisterFragment"
    }

    private var _binding: FragmentEmailRegisterBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: NewUserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmailRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        setObservers()
    }

    private fun setObservers() {
        userViewModel.user.observe(viewLifecycleOwner) {
            binding.etEmail.setText(it.email)
        }
    }

    private fun initListener() {
        binding.btnContinueEmail.setOnClickListener {
            val email = binding.etEmail.text.toString()
            if (email.isEmailValid()) {
                binding.ilEmail.error = null
                userViewModel.updateEmail(email)
                findNavController().navigate(EmailRegisterFragmentDirections.actionEmailRegisterFragmentToPasswordRegisterFragment())
            } else {
                binding.ilEmail.error = "Preencha o campo com o seu email!"
            }
        }
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}