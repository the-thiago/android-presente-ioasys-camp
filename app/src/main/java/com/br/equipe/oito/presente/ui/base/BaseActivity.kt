package com.br.equipe.oito.presente.ui.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.br.equipe.oito.presente.core.NetworkConnection

open class BaseActivity : AppCompatActivity() {

    private val networkConnection by lazy { NetworkConnection(applicationContext) }

    fun initNetworkVerification() {
        networkConnection.observe(this) { isConnected ->
            if (isConnected) {

            } else {
                Toast.makeText(this, "Sem", Toast.LENGTH_SHORT).show()
            }
        }
    }

}