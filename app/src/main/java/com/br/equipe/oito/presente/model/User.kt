package com.br.equipe.oito.presente.model

data class User(
    val typeOfUser: String = "",
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var locationCity: String = "",
    var locationState: String = "",
    var cep: String = "", // Don't used in backend
    var gender: String = "",
    var sexualOrientation: String = "",
    var race: String = "",

    // Interests
    var android: Boolean = false,
    var backEnd: Boolean = false,
    var frontEnd: Boolean = false,
    var projectManager: Boolean = false,
    var ios: Boolean = false,
    var workTips: Boolean = false,
    var uxUi: Boolean = false,
)