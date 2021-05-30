package com.br.equipe.oito.presente.ui.login

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.core.NetworkConnection
import com.br.equipe.oito.presente.databinding.ActivityLoginBinding
import com.br.equipe.oito.presente.ui.base.BaseActivity
import com.br.equipe.oito.presente.util.invisible
import com.br.equipe.oito.presente.util.visible

class LoginActivity : BaseActivity() {

    companion object {
        const val TAG = "LoginActivity"
    }

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNetworkVerification()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        changeStatusBarColor()
        val view = binding.root
        setContentView(view)
    }

    private fun changeStatusBarColor() {
        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor =
            ResourcesCompat.getColor(resources, R.color.status_bar_orange, null)
    }

    fun hideLoading() {
        binding.loadingGroup.invisible()
    }

    fun showLoading() {
        binding.loadingGroup.visible()
    }

}