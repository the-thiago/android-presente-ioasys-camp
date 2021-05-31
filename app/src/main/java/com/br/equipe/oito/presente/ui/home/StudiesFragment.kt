package com.br.equipe.oito.presente.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.br.equipe.oito.presente.databinding.FragmentStudiesBinding

class StudiesFragment : Fragment() {

    private var _binding: FragmentStudiesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudiesBinding.inflate(inflater, container, false)
        return binding.root
    }

}