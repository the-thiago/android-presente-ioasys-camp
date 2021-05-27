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
import com.br.equipe.oito.presente.databinding.FragmentSexualOrientationBinding
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel

class SexualOrientationFragment : Fragment() {

    private var _binding: FragmentSexualOrientationBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: NewUserViewModel by activityViewModels()
    var dropDownItems = arrayOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSexualOrientationBinding.inflate(inflater, container, false)
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
                binding.etSexualOrientation.setSelection(dropDownItems.indexOf(newUser.sexualOrientation))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        initDropdownSexualOrientation()
    }

    private fun initDropdownSexualOrientation() {
        dropDownItems = resources.getStringArray(R.array.sexualOrientations)
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item_dropdown, dropDownItems)
        (binding.ilSexualOrientation.editText as? AutoCompleteTextView)?.setAdapter(adapter)
    }

    private fun initListener() {
        binding.btnContinueSexualOrientation.setOnClickListener {
            if (dropDownItems.contains(userViewModel.user.value?.sexualOrientation)) {
                findNavController().navigate(SexualOrientationFragmentDirections.actionSexualOrientationFragmentToRaceFragment())
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
        binding.etSexualOrientation.setOnItemClickListener { _, _, position, _ ->
            userViewModel.updateSexualOrientation(dropDownItems[position])
        }
    }

}