package com.br.equipe.oito.presente.ui.home.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.FragmentContentBinding
import com.br.equipe.oito.presente.model.Content
import com.br.equipe.oito.presente.ui.home.HomeFragment.Companion.BLOG_TYPE
import com.br.equipe.oito.presente.ui.home.HomeFragment.Companion.COURSE_TYPE
import com.br.equipe.oito.presente.ui.home.HomeFragment.Companion.JOB_TYPE

class ContentFragment : Fragment() {

    companion object {
        val coursesContent = listOf(
            Content(
                title = "Teoria das cores",
                description = "Teoria do Design",
                image = R.drawable.ic_temp_course1
            ),
            Content(
                title = "Como montar um briefing de UX writing",
                description = "UX Writing",
                image = R.drawable.ic_temp_course2
            )
        )
        val blogContent = listOf(
            Content(
                title = "Dicas para designers que buscam trabalhar no...",
                description = "Dicas de trabalho",
                image = R.drawable.ic_temp_blog1
            ),
            Content(
                title = "Indicações do mês",
                description = "Recomendações",
                image = R.drawable.ic_temp_blog2
            )
        )
        val jobContent = listOf(
            Content(
                title = "Designer de Produto",
                description = "Apperture Science",
                image = R.drawable.ic_temp_job1
            ),
            Content(
                title = "UX Writer Jr.",
                description = "Orwell",
                image = R.drawable.ic_temp_job2
            )
        )
    }

    private var _binding: FragmentContentBinding? = null
    private val binding get() = _binding!!
    private val args: ContentFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTexts()
        initListeners()
        initRecycler()
    }

    private fun initRecycler() {
        when (args.typeOfContent) {
            COURSE_TYPE -> binding.contentRecycler.adapter =
                ContentsAdapter(coursesContent, ::clickItem)
            BLOG_TYPE -> binding.contentRecycler.adapter =
                ContentsAdapter(blogContent, ::clickItem)
            JOB_TYPE -> binding.contentRecycler.adapter =
                ContentsAdapter(jobContent, ::clickItem)
        }
    }

    private fun setTexts() {
        when (args.typeOfContent) {
            COURSE_TYPE -> {
                binding.tvContentTypeTitle.text = "Cursos"
                binding.tvContentTypeTitle.setTextColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.green_back_end,
                        null
                    )
                )
                binding.tvContentTypeDescription.text = "Confira cursos livres e temporários"
            }
            BLOG_TYPE -> {
                binding.tvContentTypeTitle.text = "Blog"
                binding.tvContentTypeTitle.setTextColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.progress_bar_pink,
                        null
                    )
                )
                binding.tvContentTypeDescription.text = "Leituras complementares"
            }
            JOB_TYPE -> {
                binding.tvContentTypeTitle.text = "Vagas"
                binding.tvContentTypeTitle.setTextColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.purple_android,
                        null
                    )
                )
                binding.tvContentTypeDescription.text = "Oportunidades para você"
            }
        }
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.tvBackView.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun clickItem() {
        if (args.typeOfContent == BLOG_TYPE) {
            findNavController().navigate(ContentFragmentDirections.actionContentFragmentToDetailsFragment())
        } else {
            Toast.makeText(
                requireContext(),
                "Em breve, vamos liberar o acesso!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}