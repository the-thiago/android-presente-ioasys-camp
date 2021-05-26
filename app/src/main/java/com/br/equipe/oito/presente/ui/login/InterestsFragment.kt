package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.FragmentInterestsBinding
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel

class InterestsFragment : Fragment() {

    private var _binding: FragmentInterestsBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: NewUserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInterestsBinding.inflate(inflater, container, false)
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

    private fun initObservers() {
        userViewModel.user.observe(viewLifecycleOwner) { newUser ->
            when (newUser.android) {
                true -> updateBackgroundColor(binding.tvAndroid, R.color.purple_android)
                false -> updateBackgroundColor(binding.tvAndroid, R.color.progress_bar_gray)
            }
            when (newUser.backEnd) {
                true -> updateBackgroundColor(binding.tvBackEnd, R.color.green_back_end)
                false -> updateBackgroundColor(binding.tvBackEnd, R.color.progress_bar_gray)
            }
            when (newUser.frontEnd) {
                true -> updateBackgroundColor(binding.tvFrontEnd, R.color.orange_front_end)
                false -> updateBackgroundColor(binding.tvFrontEnd, R.color.progress_bar_gray)
            }
            when (newUser.projectManager) {
                true -> updateBackgroundColor(
                    binding.tvProjectManagement,
                    R.color.pink_project_management
                )
                false -> updateBackgroundColor(
                    binding.tvProjectManagement,
                    R.color.progress_bar_gray
                )
            }
            when (newUser.ios) {
                true -> updateBackgroundColor(binding.tvIos, R.color.green_ios)
                false -> updateBackgroundColor(binding.tvIos, R.color.progress_bar_gray)
            }
            when (newUser.workTips) {
                true -> updateBackgroundColor(binding.tvWorkTips, R.color.light_blue_work_tips)
                false -> updateBackgroundColor(binding.tvWorkTips, R.color.progress_bar_gray)
            }
            when (newUser.uxUi) {
                true -> updateBackgroundColor(binding.tvUxUi, R.color.yellow_ux_ui)
                false -> updateBackgroundColor(binding.tvUxUi, R.color.progress_bar_gray)
            }
        }
    }

    private fun updateBackgroundColor(tv: TextView, color: Int) {
        tv.setBackgroundColor(ContextCompat.getColor(requireContext(), color))
    }

    private fun initListener() {
        cardViewListeners()
        binding.btnFinishRegister.setOnClickListener {
            findNavController().navigate(InterestsFragmentDirections.actionInterestsFragmentToFinishRegisterFragment())
        }
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun cardViewListeners() {
        binding.androidCard.setOnClickListener {
            when (userViewModel.user.value?.android) {
                true -> userViewModel.updateAndroidInterest(false)
                else -> userViewModel.updateAndroidInterest(true)
            }
        }
        binding.backEndCard.setOnClickListener {
            when (userViewModel.user.value?.backEnd) {
                true -> userViewModel.updateBackEndInterest(false)
                else -> userViewModel.updateBackEndInterest(true)
            }
        }
        binding.frontEndCard.setOnClickListener {
            when (userViewModel.user.value?.frontEnd) {
                true -> userViewModel.updateFrontEndInterest(false)
                else -> userViewModel.updateFrontEndInterest(true)
            }
        }
        binding.projectManagementCard.setOnClickListener {
            when (userViewModel.user.value?.projectManager) {
                true -> userViewModel.updateProjectManagementInterest(false)
                else -> userViewModel.updateProjectManagementInterest(true)
            }
        }
        binding.iosCard.setOnClickListener {
            when (userViewModel.user.value?.ios) {
                true -> userViewModel.updateIosInterest(false)
                else -> userViewModel.updateIosInterest(true)
            }
        }
        binding.workTipsCard.setOnClickListener {
            when (userViewModel.user.value?.workTips) {
                true -> userViewModel.updateWorkTipsInterest(false)
                else -> userViewModel.updateWorkTipsInterest(true)
            }
        }
        binding.uxUiCard.setOnClickListener {
            when (userViewModel.user.value?.uxUi) {
                true -> userViewModel.updateUxUiInterest(false)
                else -> userViewModel.updateUxUiInterest(true)
            }
        }
    }

}