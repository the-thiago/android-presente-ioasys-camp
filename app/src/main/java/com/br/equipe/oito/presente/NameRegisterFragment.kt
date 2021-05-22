package com.br.equipe.oito.presente

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.animation.doOnEnd
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentNameRegisterBinding

class NameRegisterFragment : Fragment() {

    companion object {
        const val TAG = "NameRegisterFragment"
        const val maxProgress = 9000
        const val currentProgress = 1000
    }

    private var _binding: FragmentNameRegisterBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNameRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setProgressBar()
        initListener()
    }

    private fun initListener() {
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.btnContinueEmail.setOnClickListener {
            binding.progressBar.apply {
                max = maxProgress
                val progressBarAnimaiton =
                    ObjectAnimator.ofInt(this, "progress", EmailRegisterFragment.currentProgress)
                        .setDuration(300L)
                progressBarAnimaiton.doOnEnd {
                    findNavController().navigate(NameRegisterFragmentDirections.actionNameRegisterFragmentToEmailRegisterFragment())
                }
                progressBarAnimaiton.start()
            }
        }
    }

    private fun setProgressBar() {
        binding.progressBar.apply {
            max = maxProgress
            ObjectAnimator.ofInt(this, "progress", currentProgress)
                .setDuration(300L).start()
        }
    }

}