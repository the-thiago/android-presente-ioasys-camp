package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentCepRegisterBinding
import com.br.equipe.oito.presente.util.Mask
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel

class CepRegisterFragment : Fragment() {

    private var _binding: FragmentCepRegisterBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: NewUserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCepRegisterBinding.inflate(inflater, container, false)
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
        userViewModel.user.observe(viewLifecycleOwner) { newUser ->
            binding.ilCep.helperText = newUser.locationCity
            if (binding.etCep.text.isNullOrEmpty()) {
                binding.etCep.setText(newUser.cep.replace("-", ""))
            }
        }
    }

    private fun initListener() {
        binding.etCep.addTextChangedListener(Mask.insert(Mask.FORMAT_CEP, binding.etCep))
        binding.btnContinueCep.setOnClickListener {
            if (binding.etCep.text.isNullOrEmpty() || binding.etCep.text?.length ?: 0 < 9 || userViewModel.user.value?.locationCity.isNullOrEmpty()) {
                binding.ilCep.error = "Digite um cep válido"
                return@setOnClickListener
            }
            binding.ilCep.error = null
            findNavController().navigate(CepRegisterFragmentDirections.actionCepRegisterFragmentToGenderFragment())
        }
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.etCep.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val cep = s.toString()
                if (cep.length == 9) {
                    userViewModel.updateCityAndState(cep)
                }
            }
        })
    }

}