package com.br.equipe.oito.presente.util

import android.text.TextUtils
import android.view.View

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.GONE
}

fun String.isEmailValid(): Boolean {
    return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun Int.dpToPx(density: Float): Int {
    return (this * density).toInt()
}