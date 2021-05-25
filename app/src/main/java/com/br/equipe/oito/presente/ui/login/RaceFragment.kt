package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.FragmentRaceBinding

class RaceFragment : Fragment() {

    private var _binding: FragmentRaceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRaceBinding.inflate(inflater, container, false)
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

    override fun onResume() {
        super.onResume()
        initDropdownGenders()
    }

    private fun initDropdownGenders() {
        val items = resources.getStringArray(R.array.races)
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item_dropdown, items)
        (binding.ilRace.editText as? AutoCompleteTextView)?.setAdapter(adapter)
    }

    private fun initListener() {
        binding.btnContinueRace.setOnClickListener {
            findNavController().navigate(RaceFragmentDirections.actionRaceFragmentToInterestsFragment())
        }
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}