package com.br.equipe.oito.presente.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewUserViewModel : ViewModel() {

    var typeOfUser: MutableLiveData<Int> = MutableLiveData()

}