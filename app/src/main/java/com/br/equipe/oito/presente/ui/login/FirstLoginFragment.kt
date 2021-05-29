package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.FragmentFirstLoginBinding
import com.br.equipe.oito.presente.util.dpToPx

class FirstLoginFragment : Fragment() {

    private var _binding: FragmentFirstLoginBinding? = null
    private val binding get() = _binding!!
    private var twentyDpInPx: Int? = null
    private var twentyTwoDpInPx: Int? = null
    private var oneHundredFortyDpInPx: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstLoginBinding.inflate(inflater, container, false)
        getDimensions()
        changeConstraintLayoutPadding(oneHundredFortyDpInPx ?: 140)
        return binding.root
    }

    private fun getDimensions() {
        val density = requireContext().resources.displayMetrics.density
        twentyDpInPx = 20.dpToPx(density)
        twentyTwoDpInPx = 22.dpToPx(density)
        oneHundredFortyDpInPx = 140.dpToPx(density)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.btnStartSession.setOnClickListener {
            findNavController().navigate(FirstLoginFragmentDirections.actionFirstLoginFragmentToLoginFragment())
            changeConstraintLayoutPadding(twentyDpInPx ?: 20)
        }
        binding.btnNewAccount.setOnClickListener {
            findNavController().navigate(FirstLoginFragmentDirections.actionFirstLoginFragmentToChooseTypeOfUserFragment())
            changeConstraintLayoutPadding(twentyDpInPx ?: 20)
        }
    }

    private fun changeConstraintLayoutPadding(topInPx: Int) {
        requireActivity().findViewById<ConstraintLayout>(R.id.loginConstraintLayout).apply {
            this?.setPadding(
                twentyTwoDpInPx ?: 22,
                topInPx,
                twentyDpInPx ?: 22,
                twentyTwoDpInPx ?: 22
            )
        }
    }

//    private fun convertDpToPx(dp: Int): Int {
//        val density: Float = requireContext().resources.displayMetrics.density
//        return (dp * requireContext().resources.displayMetrics.density).toInt()
//    }

}