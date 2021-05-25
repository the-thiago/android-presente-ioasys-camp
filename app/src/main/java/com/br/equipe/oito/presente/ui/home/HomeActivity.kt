package com.br.equipe.oito.presente.ui.home

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    companion object {
        const val TAG = "HomeActivity"
    }

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        changeStatusBarColor()
        setContentView(binding.root)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navController = findNavController(R.id.fragmentHome)
        binding.bottomNavigation.setupWithNavController(navController)
//        binding.bottomNavigation.setLayerType(LabelVisibilityMode.LABEL_VISIBILITY_LABELED)
    }

    private fun changeStatusBarColor() {
        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor =
            ResourcesCompat.getColor(resources, R.color.status_bar_orange, null)
    }

}