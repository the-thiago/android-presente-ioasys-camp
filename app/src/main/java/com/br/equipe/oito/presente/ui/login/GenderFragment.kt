package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.FragmentGenderBinding
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel

class GenderFragment : Fragment() {

    private var _binding: FragmentGenderBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: NewUserViewModel by activityViewModels()
    var dropDownItems = arrayOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGenderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        initListener()
    }

    private fun initObserver() {
        userViewModel.user.observe(viewLifecycleOwner) { newUser ->
            try {
                binding.etGender.setSelection(dropDownItems.indexOf(newUser.gender))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        initDropdownGenders()
    }

    private fun initDropdownGenders() {
        dropDownItems = resources.getStringArray(R.array.genders)
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item_dropdown, dropDownItems)
        (binding.ilGender.editText as? AutoCompleteTextView)?.setAdapter(adapter)
    }

    private fun initListener() {
        binding.btnContinueGender.setOnClickListener {
            if (dropDownItems.contains(userViewModel.user.value?.gender)) {
                findNavController().navigate(GenderFragmentDirections.actionGenderFragmentToSexualOrientationFragment())
            } else {
                Toast.makeText(
                    requireContext(),
                    "Selecione uma opção para continuar!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.etGender.setOnItemClickListener { _, _, position, _ ->
            userViewModel.updateGender(dropDownItems[position])
        }
    }

}