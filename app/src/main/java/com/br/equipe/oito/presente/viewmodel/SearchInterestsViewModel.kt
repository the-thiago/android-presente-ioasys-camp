package com.br.equipe.oito.presente.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchInterestsViewModel : ViewModel() {

    companion object {
        const val TAG = "SearchInterestsViewModel"
    }

    private var _hasAndroidInterest = MutableLiveData(true)
    val hasAndroidInterest: LiveData<Boolean> = _hasAndroidInterest

    private var _hasBackEndInterest = MutableLiveData(true)
    val hasBackEndInterest: LiveData<Boolean> = _hasBackEndInterest

    private var _hasFrontEndInterest = MutableLiveData(true)
    val hasFrontEndInterest: LiveData<Boolean> = _hasFrontEndInterest

    private var _hasUxUiInterest = MutableLiveData(true)
    val hasUxUiInterest: LiveData<Boolean> = _hasUxUiInterest

    private var _hasProjectManagementInterest = MutableLiveData(true)
    val hasProjectManagementInterest: LiveData<Boolean> = _hasProjectManagementInterest

    fun updateAndroidInterest(hasInterest: Boolean) {
        _hasAndroidInterest.value = hasInterest
    }

    fun updateBackEndInterest(hasInterest: Boolean) {
        _hasBackEndInterest.value = hasInterest
    }

    fun updateFrontEndInterest(hasInterest: Boolean) {
        _hasFrontEndInterest.value = hasInterest
    }

    fun updateProjectManagementInterest(hasInterest: Boolean) {
        _hasProjectManagementInterest.value = hasInterest
    }

    fun updateUxUiInterest(hasInterest: Boolean) {
        _hasUxUiInterest.value = hasInterest
    }

}