package com.br.equipe.oito.presente.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    companion object {
        const val TAG = "HomeFragment"
        const val BLOG_TYPE = "BLOG_TYPE"
        const val COURSE_TYPE = "COURSE_TYPE"
        const val JOB_TYPE = "JOB_TYPE"
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
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
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFiltersFragment())
        }
        binding.cardBlog.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToContentFragment(
                    BLOG_TYPE
                )
            )
        }
        binding.cardJobs.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToContentFragment(
                    JOB_TYPE
                )
            )
        }
        binding.cardCourses.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToContentFragment(
                    COURSE_TYPE
                )
            )
        }
    }

}