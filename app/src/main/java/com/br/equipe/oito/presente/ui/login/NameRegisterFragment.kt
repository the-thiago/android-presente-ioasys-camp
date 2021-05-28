package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentNameRegisterBinding
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel

class NameRegisterFragment : Fragment() {

    private var _binding: FragmentNameRegisterBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: NewUserViewModel by activityViewModels()

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
        initObserver()
    }

    private fun initObserver() {
        userViewModel.user.observe(viewLifecycleOwner) {
            binding.etName.setText(it.name)
        }
    }

    private fun initListener() {
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.btnContinueName.setOnClickListener {
            val name = binding.etName.text.toString()
            if (name.isNotEmpty()) {
                userViewModel.updateName(name)
                findNavController().navigate(NameRegisterFragmentDirections.actionNameRegisterFragmentToEmailRegisterFragment())
            } else {
                Toast.makeText(requireContext(), "Preencha o nome!", Toast.LENGTH_LONG).show()
            }
        }
    }

}