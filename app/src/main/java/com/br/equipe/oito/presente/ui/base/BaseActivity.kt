package com.br.equipe.oito.presente.ui.base


import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.br.equipe.oito.presente.core.NetworkConnection

open class BaseActivity : AppCompatActivity() {

    private val networkConnection by lazy { NetworkConnection(applicationContext) }
    private var noNetworkConnectionDialog: AlertDialog? = null

    fun initNetworkVerification() {
        networkConnection.observe(this) { isConnected ->
            if (isConnected) {
                noNetworkConnectionDialog?.dismiss()
            } else {
                noNetworkConnectionDialog = AlertDialog.Builder(this)
                    .setMessage("Verifique a conexão com a internet para continuar!")
                    .setCancelable(false)
                    .setTitle("Sem conexão com internet")
                    .create()
                noNetworkConnectionDialog?.show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        noNetworkConnectionDialog?.dismiss()
    }

}