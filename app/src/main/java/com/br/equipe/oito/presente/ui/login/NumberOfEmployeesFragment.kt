package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.FragmentNumberOfEmployeesBinding

class NumberOfEmployeesFragment : Fragment() {

    private var _binding: FragmentNumberOfEmployeesBinding? = null
    private val binding get() = _binding!!

    private var numberOfEmployeesStringArray: Array<String> = arrayOf()
    private var selectedNumber = "Sou autônomo(a)"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNumberOfEmployeesBinding.inflate(inflater, container, false)
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
        numberOfEmployeesStringArray = resources.getStringArray(R.array.numberOfEmployees)
        binding.ivMinus.setOnClickListener {
            onMinusClicked()
        }
        binding.ivPlus.setOnClickListener {
            onPlusClicked()
        }
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.btnFinishRegister.setOnClickListener {
            findNavController().navigate(NumberOfEmployeesFragmentDirections.actionNumberOfEmployeesFragmentToInterestsFragment())
        }
    }

    private fun onPlusClicked() {
        if (selectedNumber == "mais de 5.000") return
        if (selectedNumber == "Sou autônomo(a)") {
            binding.ivMinus.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_minus_orange
                )
            )
        }
        if (selectedNumber == "1.001 – 5.000") {
            binding.ivPlus.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_plus_gray
                )
            )
        }
        val selected =
            numberOfEmployeesStringArray[numberOfEmployeesStringArray.indexOf(binding.tvNumberOfEmployees.text) + 1]
        binding.tvNumberOfEmployees.text = selected
        selectedNumber = selected
    }

    private fun onMinusClicked() {
        if (selectedNumber == "Sou autônomo(a)") return
        if (selectedNumber == "mais de 5.000") {
            binding.ivPlus.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_plus_green
                )
            )
        }
        if (selectedNumber == "1 – 50") {
            binding.ivMinus.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_minus_gray
                )
            )
        }
        val selected =
            numberOfEmployeesStringArray[numberOfEmployeesStringArray.indexOf(binding.tvNumberOfEmployees.text) - 1]
        binding.tvNumberOfEmployees.text = selected
        selectedNumber = selected
    }

}