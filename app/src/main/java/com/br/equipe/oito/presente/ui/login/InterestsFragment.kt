package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.FragmentInterestsBinding

class InterestsFragment : Fragment() {

    private var _binding: FragmentInterestsBinding? = null
    private val binding get() = _binding!!

    private var isAndroidCardEnabled = false
    private var isBackEndCardEnabled = false
    private var isFrontEndCardEnabled = false
    private var isProjectManagementCardEnabled = false
    private var isIosCardEnabled = false
    private var isWorkTipsCardEnabled = false
    private var isUxUiCardEnabled = false

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
            isAndroidCardEnabled = if (isAndroidCardEnabled) {
                binding.tvAndroid.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.progress_bar_gray
                    )
                )
                false
            } else {
                binding.tvAndroid.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.purple_android
                    )
                )
                true
            }
        }
        binding.backEndCard.setOnClickListener {
            isBackEndCardEnabled = if (isBackEndCardEnabled) {
                binding.tvBackEnd.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.progress_bar_gray
                    )
                )
                false
            } else {
                binding.tvBackEnd.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green_back_end
                    )
                )
                true
            }
        }
        binding.frontEndCard.setOnClickListener {
            isFrontEndCardEnabled = if (isFrontEndCardEnabled) {
                binding.tvFrontEnd.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.progress_bar_gray
                    )
                )
                false
            } else {
                binding.tvFrontEnd.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.orange_front_end
                    )
                )
                true
            }
        }
        binding.projectManagementCard.setOnClickListener {
            isProjectManagementCardEnabled = if (isProjectManagementCardEnabled) {
                binding.tvProjectManagement.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.progress_bar_gray
                    )
                )
                false
            } else {
                binding.tvProjectManagement.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.pink_project_management
                    )
                )
                true
            }
        }
        binding.iosCard.setOnClickListener {
            isIosCardEnabled = if (isIosCardEnabled) {
                binding.tvIos.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.progress_bar_gray
                    )
                )
                false
            } else {
                binding.tvIos.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green_ios
                    )
                )
                true
            }
        }
        binding.workTipsCard.setOnClickListener {
            isWorkTipsCardEnabled = if (isWorkTipsCardEnabled) {
                binding.tvWorkTips.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.progress_bar_gray
                    )
                )
                false
            } else {
                binding.tvWorkTips.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.light_blue_work_tips
                    )
                )
                true
            }
        }
        binding.uxUiCard.setOnClickListener {
            isUxUiCardEnabled = if (isUxUiCardEnabled) {
                binding.tvUxUi.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.progress_bar_gray
                    )
                )
                false
            } else {
                binding.tvUxUi.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.yellow_ux_ui
                    )
                )
                true
            }
        }
    }

}