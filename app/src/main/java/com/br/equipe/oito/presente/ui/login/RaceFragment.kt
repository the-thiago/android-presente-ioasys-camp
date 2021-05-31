package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.FragmentRaceBinding
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel

class RaceFragment : Fragment() {

    companion object {
        const val TAG = "RaceFragment"
    }

    private var _binding: FragmentRaceBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: NewUserViewModel by activityViewModels()
    private var dropDownItems = arrayOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView: ")
        _binding = FragmentRaceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView: ")
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated: ")
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        initListener()
    }

    override fun onResume() {
        Log.d(TAG, "onResume: ")
        super.onResume()
        initDropdownRaces()
    }

    private fun initObserver() {
        Log.d(TAG, "initObserver: ")
        userViewModel.user.observe(viewLifecycleOwner) { newUser ->
            try {
                binding.etRace.setSelection(dropDownItems.indexOf(newUser.race))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun initDropdownRaces() {
        Log.d(TAG, "initDropdownRaces: ")
        dropDownItems = resources.getStringArray(R.array.races)
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item_dropdown, dropDownItems)
        (binding.ilRace.editText as? AutoCompleteTextView)?.setAdapter(adapter)
    }

    private fun initListener() {
        Log.d(TAG, "initListener: ")
        binding.btnContinueRace.setOnClickListener {
            if (dropDownItems.contains(userViewModel.user.value?.race)) {
                findNavController().navigate(RaceFragmentDirections.actionRaceFragmentToInterestsFragment())
                binding.ilRace.error = null
            } else {
                binding.ilRace.error = "Selecione uma opção!"
            }
        }
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.etRace.setOnItemClickListener { _, _, position, _ ->
            userViewModel.updateRace(dropDownItems[position])
        }
    }

}