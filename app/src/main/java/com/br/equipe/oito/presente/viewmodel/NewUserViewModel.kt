package com.br.equipe.oito.presente.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.equipe.oito.presente.model.User

class NewUserViewModel : ViewModel() {

    companion object {
        const val TAG = "NewUserViewModel"
    }

    var typeOfUser: MutableLiveData<Int> = MutableLiveData()

    private var _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun setUser(user: User) {
        _user.value = user
    }

    fun updateAndroidInterest(hasInterest: Boolean) {
        _user.value?.android = hasInterest
        notifyObservers()
    }

    fun updateBackEndInterest(hasInterest: Boolean) {
        _user.value?.backEnd = hasInterest
        notifyObservers()
    }

    fun updateFrontEndInterest(hasInterest: Boolean) {
        _user.value?.frontEnd = hasInterest
        notifyObservers()
    }

    fun updateProjectManagementInterest(hasInterest: Boolean) {
        _user.value?.projectManager = hasInterest
        notifyObservers()
    }

    fun updateIosInterest(hasInterest: Boolean) {
        _user.value?.ios = hasInterest
        notifyObservers()
    }

    fun updateWorkTipsInterest(hasInterest: Boolean) {
        _user.value?.workTips = hasInterest
        notifyObservers()
    }

    fun updateUxUiInterest(hasInterest: Boolean) {
        _user.value?.uxUi = hasInterest
        notifyObservers()
    }

    private fun notifyObservers() {
        _user.value = _user.value
    }

}

