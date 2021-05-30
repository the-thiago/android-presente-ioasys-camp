package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.api.account.Credentials
import com.br.equipe.oito.presente.databinding.FragmentLoginBinding
import com.br.equipe.oito.presente.util.gone
import com.br.equipe.oito.presente.util.visible
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel

class LoginFragment : Fragment() {

    companion object {
        const val TAG = "LoginFragment"
    }

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: NewUserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initObserver()
    }

    private fun initObserver() {
        userViewModel.signInResult.observe(viewLifecycleOwner) {
            Log.d(TAG, "initObserver: signIn")
            if (it?.token?.isNotBlank() == true) {
                findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
                requireActivity().run {
                    findViewById<Group>(R.id.loadingGroup).gone()
                    finish()
                }
            } else {
                binding.ilPassword.error = "Credenciais inválidas"
                binding.ilEmail.error = " "
                requireActivity().findViewById<Group>(R.id.loadingGroup).gone()
            }
        }
    }

    private fun initListeners() {
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.btnStartSession.setOnClickListener {
            requireActivity().findViewById<Group>(R.id.loadingGroup).visible()
            userViewModel.signIn(
                Credentials(
                    email = binding.etEmail.text.toString(),
                    password = binding.etPassword.text.toString()
                )
            )
        }
        binding.btnGoogle.setOnClickListener {
            Toast.makeText(requireContext(), "Não implementado...", Toast.LENGTH_SHORT).show()
        }
        binding.btnFacebook.setOnClickListener {
            Toast.makeText(requireContext(), "Não implementado...", Toast.LENGTH_SHORT).show()
        }
    }

}