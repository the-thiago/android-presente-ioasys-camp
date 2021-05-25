package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.FragmentEducationBinding

class EducationFragment : Fragment() {

    companion object {
        const val TAG = "EducationFragment"
    }

    private val selectedSkillsCard = mutableMapOf<String, Boolean>()
    private var skillsStringArray: Array<String> = arrayOf()
    private var formationsStringArray: Array<String> = arrayOf()
    private var selectedFormation = "Sou autodidata"

    private var _binding: FragmentEducationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEducationBinding.inflate(inflater, container, false)
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
        initSkillsCards()
        formationsStringArray = resources.getStringArray(R.array.formations)
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
            findNavController().navigate(EducationFragmentDirections.actionEducationFragmentToFinishRegisterFragment())
        }
    }

    private fun onPlusClicked() {
        if (selectedFormation == "Pós-doutorado") return
        if (selectedFormation == "Sou autodidata") {
            binding.ivMinus.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_minus_orange
                )
            )
        }
        if (selectedFormation == "Doutorado") {
            binding.ivPlus.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_plus_gray
                )
            )
        }
        val selected =
            formationsStringArray[formationsStringArray.indexOf(binding.tvEducationLevel.text) + 1]
        binding.tvEducationLevel.text = selected
        selectedFormation = selected
    }

    private fun onMinusClicked() {
        if (selectedFormation == "Sou autodidata") return
        if (selectedFormation == "Pós-doutorado") {
            binding.ivPlus.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_plus_green
                )
            )
        }
        if (selectedFormation == "Superior incompleto") {
            binding.ivMinus.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_minus_gray
                )
            )
        }
        val selected =
            formationsStringArray[formationsStringArray.indexOf(binding.tvEducationLevel.text) - 1]
        binding.tvEducationLevel.text = selected
        selectedFormation = selected
    }

    private fun initSkillsCards() {
        skillsStringArray = resources.getStringArray(R.array.interests)
        skillsStringArray.forEach {
            selectedSkillsCard[it] = false
        }
        binding.androidCard.setOnClickListener {
            onCardClicked("Android", binding.tvAndroid)
        }
        binding.backEndCard.setOnClickListener {
            onCardClicked("Back-End", binding.tvBackEnd)
        }
        binding.frontEndCard.setOnClickListener {
            onCardClicked("Front-End", binding.tvFrontEnd)
        }
        binding.projectManagementCard.setOnClickListener {
            onCardClicked("Gerencimanto de projetos", binding.tvProjectManagement)
        }
        binding.iosCard.setOnClickListener {
            onCardClicked("iOS", binding.tvIos)
        }
        binding.workTipsCard.setOnClickListener {
            onCardClicked("Dicas de trabalho", binding.tvWorkTips)
        }
        binding.uxUiCard.setOnClickListener {
            onCardClicked("UX/UI", binding.tvUxUi)
        }
    }

    private fun onCardClicked(skill: String, selectedTextView: TextView) {
        skillsStringArray.forEach {
            selectedSkillsCard[it] = false
        }
        selectedSkillsCard[skill] = true
        binding.tvAndroid.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.progress_bar_gray
            )
        )
        binding.tvBackEnd.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.progress_bar_gray
            )
        )
        binding.tvFrontEnd.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.progress_bar_gray
            )
        )
        binding.tvProjectManagement.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.progress_bar_gray
            )
        )
        binding.tvIos.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.progress_bar_gray
            )
        )
        binding.tvWorkTips.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.progress_bar_gray
            )
        )
        binding.tvUxUi.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.progress_bar_gray
            )
        )
        selectedTextView.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.light_green_button
            )
        )
    }

}