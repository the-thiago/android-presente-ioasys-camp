package com.br.equipe.oito.presente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentNameRegisterBinding

class NameRegisterFragment : Fragment() {

    private var _binding: FragmentNameRegisterBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNameRegisterBinding.inflate(inflater, container, false)
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
                findNavController().navigate(NameRegisterFragmentDirections.actionNameRegisterFragmentToEmailRegisterFragment())
            }
        }
    }

}