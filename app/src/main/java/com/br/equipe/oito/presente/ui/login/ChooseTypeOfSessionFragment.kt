package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentChooseTypeOfSessionBinding

class ChooseTypeOfSessionFragment : Fragment() {

    companion object {
        const val TAG = "ChooseTypeOfSessionFragment"
        const val GOOGLE_METHOD = "google"
        const val EMAIL_METHOD = "email"
        const val FACEBOOK_METHOD = "facebook"
        const val TRANSPARENT = 0.5F
        const val VISIBLE = 1.0F
    }

    private var _binding: FragmentChooseTypeOfSessionBinding? = null
    private val binding get() = _binding!!

    private var loginMethod: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseTypeOfSessionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.btnStartSession.setOnClickListener {
            if (loginMethod == null) {
                Toast.makeText(requireContext(), "Selecione alguma opção!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (loginMethod == EMAIL_METHOD) {
                findNavController().navigate(ChooseTypeOfSessionFragmentDirections.actionChooseTypeOfSessionFragmentToNameRegisterFragment())
            } else {
                Toast.makeText(requireContext(), "Em implementação...", Toast.LENGTH_SHORT).show()
            }
        }
        binding.ivEmail.setOnClickListener {
            emailMethodClicked()
        }
        binding.tvEmail.setOnClickListener {
            emailMethodClicked()
        }
        binding.ivGoogle.setOnClickListener {
            googleMethodClicked()
        }
        binding.tvGoogle.setOnClickListener {
            googleMethodClicked()
        }
        binding.ivFacebook.setOnClickListener {
            facebookMethodClicked()
        }
        binding.tvFacebook.setOnClickListener {
            facebookMethodClicked()
        }
    }

    private fun facebookMethodClicked() {
        loginMethod = FACEBOOK_METHOD
        binding.ivGoogle.alpha = TRANSPARENT
        binding.tvGoogle.alpha = TRANSPARENT
        binding.ivFacebook.alpha = VISIBLE
        binding.tvFacebook.alpha = VISIBLE
        binding.ivEmail.alpha = TRANSPARENT
        binding.tvEmail.alpha = TRANSPARENT
    }

    private fun googleMethodClicked() {
        loginMethod = GOOGLE_METHOD
        binding.ivGoogle.alpha = VISIBLE
        binding.tvGoogle.alpha = VISIBLE
        binding.ivFacebook.alpha = TRANSPARENT
        binding.tvFacebook.alpha = TRANSPARENT
        binding.ivEmail.alpha = TRANSPARENT
        binding.tvEmail.alpha = TRANSPARENT
    }

    private fun emailMethodClicked() {
        loginMethod = EMAIL_METHOD
        binding.ivGoogle.alpha = TRANSPARENT
        binding.tvGoogle.alpha = TRANSPARENT
        binding.ivFacebook.alpha = TRANSPARENT
        binding.tvFacebook.alpha = TRANSPARENT
        binding.ivEmail.alpha = VISIBLE
        binding.tvEmail.alpha = VISIBLE
    }

}