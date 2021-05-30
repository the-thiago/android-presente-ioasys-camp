package com.br.equipe.oito.presente.api.account

data class NewApprentice(
    val about: String? = null,
    val birthday: String? = null,
    val email: String? = null,
    val gender: String? = null,
    val graduation: String? = null,
    val interests: List<String>? = null,
    val is_admin: Boolean? = null,
    val locationCity: String? = null,
    val locationState: String? = null,
    val name: String? = null,
    val password: String? = null,
    val race: String? = null,
    val sexualOrientation: String? = null
)