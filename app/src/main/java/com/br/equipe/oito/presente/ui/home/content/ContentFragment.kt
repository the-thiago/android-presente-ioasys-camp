package com.br.equipe.oito.presente.ui.home.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.FragmentContentBinding
import com.br.equipe.oito.presente.model.Content
import com.br.equipe.oito.presente.ui.home.HomeFragment.Companion.BLOG_TYPE
import com.br.equipe.oito.presente.ui.home.HomeFragment.Companion.COURSE_TYPE
import com.br.equipe.oito.presente.ui.home.HomeFragment.Companion.JOB_TYPE

class ContentFragment : Fragment() {

    private var _binding: FragmentContentBinding? = null
    private val binding get() = _binding!!
    val args: ContentFragmentArgs by navArgs()

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
        binding.contentRecycler.adapter = ContentsAdapter(mockedContent())
    }

    private fun mockedContent(): List<Content> {
        val contents = mutableListOf<Content>()
        repeat(10) {
            contents.add(
                Content(
                    image = R.drawable.ic_notification_image,
                    title = "UX Writer Jr.",
                    description = "Orwell"
                )
            )
        }
        return contents
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
    }

}