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

class FirstLoginFragment : Fragment() {

    private var _binding: FragmentFirstLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstLoginBinding.inflate(inflater, container, false)
        changeConstraintLayoutPadding(140)
        return binding.root
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
            changeConstraintLayoutPadding(20)
        }
        binding.btnNewAccount.setOnClickListener {
            findNavController().navigate(FirstLoginFragmentDirections.actionFirstLoginFragmentToChooseTypeOfUserFragment())
            changeConstraintLayoutPadding(20)
        }
    }

    private fun changeConstraintLayoutPadding(top: Int) {
        requireActivity().findViewById<ConstraintLayout>(R.id.loginConstraintLayout).apply {
            this?.setPadding(
                convertDpToPx(22),
                convertDpToPx(top),
                convertDpToPx(20),
                convertDpToPx(22)
            )
        }
    }

    private fun convertDpToPx(dp: Int): Int {
        return (dp * requireContext().resources.displayMetrics.density).toInt()
    }

}