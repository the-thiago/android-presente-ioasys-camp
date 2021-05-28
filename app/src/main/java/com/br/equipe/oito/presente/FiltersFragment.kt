package com.br.equipe.oito.presente

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.equipe.oito.presente.databinding.FragmentFiltersBinding
import com.br.equipe.oito.presente.databinding.FragmentHomeBinding

class FiltersFragment : Fragment() {

    private var _binding: FragmentFiltersBinding? = null
    private val binding get() = _binding!!

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
    }

    private fun initListener() {
        binding.ivFilter.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.btnSaveAlterations.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}