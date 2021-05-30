package com.br.equipe.oito.presente.api.account

data class SignInResult(
    val email: String,
    val name: String,
    var token: String
)