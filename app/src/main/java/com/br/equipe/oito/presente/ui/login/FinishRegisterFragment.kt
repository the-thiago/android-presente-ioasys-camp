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
import com.br.equipe.oito.presente.databinding.FragmentFinishRegisterBinding
import com.br.equipe.oito.presente.util.gone
import com.br.equipe.oito.presente.util.visible
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
        initObserver()
        Log.d(TAG, "onViewCreated: {${userViewModel.user.value.toString()}}")
    }

    private fun initObserver() {
        userViewModel.signUpCode.observe(viewLifecycleOwner) { code ->
            Log.d(LoginFragment.TAG, "initObserver: signUp")
            when (code) {
                201 -> {
                    Log.d(TAG, "initObserver: login aq")
                    userViewModel.signIn(
                        Credentials(
                            userViewModel.user.value?.email ?: "",
                            userViewModel.user.value?.password ?: ""
                        )
                    )
                    findNavController().navigate(R.id.action_finishRegisterFragment_to_homeActivity)
                    requireActivity().run {
                        findViewById<Group>(R.id.loadingGroup).gone()
                        finish()
                    }
                }
                else -> {
                    Toast.makeText(
                        requireContext(),
                        "Não foi possível finalizar o cadastro",
                        Toast.LENGTH_SHORT
                    ).show()
                    requireActivity().findViewById<Group>(R.id.loadingGroup).gone()
                }
            }
        }
    }

    private fun initListener() {
        binding.btnSignUp.setOnClickListener {
            requireActivity().findViewById<Group>(R.id.loadingGroup).visible()
            userViewModel.signUp()
        }
    }

}