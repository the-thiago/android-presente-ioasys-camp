package com.br.equipe.oito.presente

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.equipe.oito.presente.databinding.FragmentCompanyBinding
import com.br.equipe.oito.presente.databinding.FragmentGenderBinding

class CompanyFragment : Fragment() {

    private var _binding: FragmentCompanyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompanyBinding.inflate(inflater, container, false)
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

    }

}