package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.FragmentFinishRegisterBinding
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel

class FinishRegisterFragment : Fragment() {

    companion object {
        const val TAG = "FinishRegisterFragment"
    }

    private var _binding: FragmentFinishRegisterBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: NewUserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFinishRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        Log.d(TAG, "onViewCreated: {${userViewModel.user.value.toString()}}")
    }

    private fun initListener() {
        binding.btnSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_finishRegisterFragment_to_homeActivity)
            requireActivity().finish()
        }
    }

}