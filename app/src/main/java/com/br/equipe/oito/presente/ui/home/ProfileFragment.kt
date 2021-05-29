package com.br.equipe.oito.presente.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.tvLogout.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToLoginActivity())
            requireActivity().finish()
        }
        binding.tvPencil.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Em breve você poderá editar seu perfil!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}