package com.br.equipe.oito.presente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentEmailRegisterBinding

class EmailRegisterFragment : Fragment() {

    companion object {
        const val TAG = "EmailRegisterFragment"
        const val maxProgress = 9000
        const val currentProgress = 2000
    }

    private var _binding: FragmentEmailRegisterBinding? = null
    private val binding get() = _binding!!

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
    }

    private fun initListener() {
        binding.btnContinueEmail.setOnClickListener {
            findNavController().navigate(EmailRegisterFragmentDirections.actionEmailRegisterFragmentToPasswordRegisterFragment())
        }
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}