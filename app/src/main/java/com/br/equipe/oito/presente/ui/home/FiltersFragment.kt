package com.br.equipe.oito.presente.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.FragmentFiltersBinding
import com.br.equipe.oito.presente.viewmodel.SearchInterestsViewModel

class FiltersFragment : Fragment() {

    private var _binding: FragmentFiltersBinding? = null
    private val binding get() = _binding!!
    private val searchFilters: SearchInterestsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFiltersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initObservers()
    }

    private fun initListener() {
        cardViewListeners()
        binding.ivFilter.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.btnSaveAlterations.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun cardViewListeners() {
        binding.androidCard.setOnClickListener {
            when (searchFilters.hasAndroidInterest.value) {
                true -> searchFilters.updateAndroidInterest(false)
                else -> searchFilters.updateAndroidInterest(true)
            }
        }
        binding.backEndCard.setOnClickListener {
            when (searchFilters.hasBackEndInterest.value) {
                true -> searchFilters.updateBackEndInterest(false)
                else -> searchFilters.updateBackEndInterest(true)
            }
        }
        binding.frontEndCard.setOnClickListener {
            when (searchFilters.hasFrontEndInterest.value) {
                true -> searchFilters.updateFrontEndInterest(false)
                else -> searchFilters.updateFrontEndInterest(true)
            }
        }
        binding.projectManagementCard.setOnClickListener {
            when (searchFilters.hasProjectManagementInterest.value) {
                true -> searchFilters.updateProjectManagementInterest(false)
                else -> searchFilters.updateProjectManagementInterest(true)
            }
        }
        binding.uxUiCard.setOnClickListener {
            when (searchFilters.hasUxUiInterest.value) {
                true -> searchFilters.updateUxUiInterest(false)
                else -> searchFilters.updateUxUiInterest(true)
            }
        }
    }

    private fun initObservers() {
        searchFilters.hasAndroidInterest.observe(viewLifecycleOwner) {
            when (it) {
                true -> updateBackgroundColor(binding.tvAndroid, R.color.purple_android)
                false -> updateBackgroundColor(binding.tvAndroid, R.color.progress_bar_gray)
            }
        }
        searchFilters.hasBackEndInterest.observe(viewLifecycleOwner) {
            when (it) {
                true -> updateBackgroundColor(binding.tvBackEnd, R.color.green_back_end)
                false -> updateBackgroundColor(binding.tvBackEnd, R.color.progress_bar_gray)
            }
        }
        searchFilters.hasFrontEndInterest.observe(viewLifecycleOwner) {
            when (it) {
                true -> updateBackgroundColor(binding.tvFrontEnd, R.color.orange_front_end)
                false -> updateBackgroundColor(binding.tvFrontEnd, R.color.progress_bar_gray)
            }
        }
        searchFilters.hasUxUiInterest.observe(viewLifecycleOwner) {
            when (it) {
                true -> updateBackgroundColor(binding.tvUxUi, R.color.yellow_ux_ui)
                false -> updateBackgroundColor(binding.tvUxUi, R.color.progress_bar_gray)
            }
        }
        searchFilters.hasProjectManagementInterest.observe(viewLifecycleOwner) {
            when (it) {
                true -> updateBackgroundColor(
                    binding.tvProjectManagement,
                    R.color.pink_project_management
                )
                false -> updateBackgroundColor(
                    binding.tvProjectManagement,
                    R.color.progress_bar_gray
                )
            }
        }
    }

    private fun updateBackgroundColor(tv: TextView, color: Int) {
        tv.setBackgroundColor(ContextCompat.getColor(requireContext(), color))
    }

}