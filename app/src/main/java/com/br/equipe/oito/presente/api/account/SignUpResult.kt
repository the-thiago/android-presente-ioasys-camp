package com.br.equipe.oito.presente.api.account

data class SignUpResult(
    val about: String,
    val birthday: String,
    val createdAt: String,
    val email: String,
    val gender: String,
    val graduation: String,
    val id: Int,
    val interests: List<String>,
    val locationCity: String,
    val locationState: String,
    val name: String,
    val race: String,
    val sexualOrientation: String,
    var token: String?,
    val updatedAt: String
)