package com.br.equipe.oito.presente.ui.login.typeofuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.FragmentChooseTypeOfUserBinding
import com.br.equipe.oito.presente.model.User
import com.br.equipe.oito.presente.viewmodel.NewUserViewModel
import kotlin.math.abs

class ChooseTypeOfUserFragment : Fragment() {

    companion object {
        val TYPE_USERS_IMAGES = listOf(
            R.drawable.ic_apprentice,
            R.drawable.ic_tutor,
            R.drawable.ic_company
        )
        const val APPRENTICE_TYPE = 0
        const val TUTOR_TYPE = 1
        const val COMPANY_TYPE = 2
    }

    private val userViewModel: NewUserViewModel by activityViewModels()
    private var _binding: FragmentChooseTypeOfUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseTypeOfUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        binding.viewPager.apply {
            adapter = SliderUserAdapter(TYPE_USERS_IMAGES)
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            val compositePageTransformer = CompositePageTransformer()
            compositePageTransformer.addTransformer(MarginPageTransformer(80))
            compositePageTransformer.addTransformer { page, position ->
                val r: Float = 1 - abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }
            setPageTransformer(compositePageTransformer)
        }
    }

    private fun initListeners() {
        binding.btnContinue.setOnClickListener {
            if (binding.viewPager.currentItem == APPRENTICE_TYPE) {
                userViewModel.setUser(User())
                findNavController().navigate(ChooseTypeOfUserFragmentDirections.actionChooseTypeOfUserFragmentToChooseTypeOfSessionFragment())
            } else {
                Toast.makeText(
                    requireContext(),
                    "Essa categoria estará disponível em breve!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.leftArea.setOnClickListener {
            binding.viewPager.let {
                if (it.currentItem != 0)
                    it.setCurrentItem(it.currentItem - 1, true)
            }
        }
        binding.rightArea.setOnClickListener {
            binding.viewPager.let {
                if (it.currentItem != 2)
                    it.setCurrentItem(it.currentItem + 1, true)
            }
        }
    }

}