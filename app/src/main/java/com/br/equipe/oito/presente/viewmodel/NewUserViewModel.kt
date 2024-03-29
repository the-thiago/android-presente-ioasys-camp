package com.br.equipe.oito.presente.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.equipe.oito.presente.api.account.*
import com.br.equipe.oito.presente.api.cep.Cep
import com.br.equipe.oito.presente.api.cep.CepService
import com.br.equipe.oito.presente.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class NewUserViewModel : ViewModel() {

    companion object {
        const val TAG = "NewUserViewModel"
    }

    var typeOfUser: MutableLiveData<Int> = MutableLiveData()

    private var _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private var _signIn = MutableLiveData<SignInResult>()
    val signInResult: LiveData<SignInResult> = _signIn

    private var _signUp = MutableLiveData<SignUpResult>()
    val signUpResult: LiveData<SignUpResult> = _signUp

    private var _signUpCode = MutableLiveData<Int>()
    val signUpCode: LiveData<Int> = _signUpCode

    fun signIn(credentials: Credentials) {
        viewModelScope.launch {
            val signInResultResponse: Response<SignInResult> =
                AccountService.create().signIn(credentials)
            if (signInResultResponse.isSuccessful) {
                withContext(Dispatchers.Main) {
                    _signIn.value = signInResultResponse.body()
                }
            } else {
                withContext(Dispatchers.Main) {
                    _signIn.value?.token = ""
                    _signIn.value = _signIn.value
                }
            }
        }
    }

    fun signUp() {
        viewModelScope.launch {
            val newApprentice = generateNewApprentice()
            Log.d(TAG, "signUp: newAppre: $newApprentice")
            val signUpResponse: Response<SignUpResult> =
                AccountService.create().signUp(newApprentice)
            _signUpCode.value = signUpResponse.code()
        }
    }

    private fun generateNewApprentice(): NewApprentice {
        val newUser = _user.value
        val interests = mutableListOf<String>()
        if (newUser?.android == true) interests.add("Android")
        if (newUser?.backEnd == true) interests.add("Backend")
        if (newUser?.frontEnd == true) interests.add("Frontend")
        if (newUser?.projectManager == true) interests.add("Gestão de projetos")
        if (newUser?.uxUi == true) interests.add("UI/UX")
        return NewApprentice(
            email = newUser?.email,
            gender = newUser?.gender,
            interests = interests,
            locationCity = newUser?.locationCity,
            locationState = newUser?.locationState,
            name = newUser?.name,
            password = newUser?.password,
            race = newUser?.race,
            sexualOrientation = newUser?.sexualOrientation
        )
    }

    fun setUser(user: User) {
        _user.value = user
    }

    fun updateName(name: String) {
        _user.value?.name = name
        notifyObservers()
    }

    fun updateEmail(email: String) {
        _user.value?.email = email
        notifyObservers()
    }

    fun updatePassword(password: String) {
        _user.value?.password = password
        notifyObservers()
    }

    fun updateCityAndState(cep: String) {
        viewModelScope.launch {
            val cepDetails: Response<Cep> = CepService.create().getCepDetails(cep)
            if (cepDetails.isSuccessful) {
                cepDetails.body().let {
                    _user.value?.locationCity = it?.localidade ?: ""
                    _user.value?.locationState = it?.uf ?: ""
                    _user.value?.cep = cep
                }
            } else {
                _user.value?.locationCity = ""
                _user.value?.locationState = ""
                _user.value?.cep = ""
            }
            withContext(Dispatchers.Main) {
                notifyObservers()
            }
        }
    }

    fun updateGender(gender: String) {
        _user.value?.gender = gender
        notifyObservers()
    }

    fun updateSexualOrientation(sexualOrientation: String) {
        _user.value?.sexualOrientation = sexualOrientation
        notifyObservers()
    }

    fun updateRace(race: String) {
        _user.value?.race = race
        notifyObservers()
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

    fun updateUxUiInterest(hasInterest: Boolean) {
        _user.value?.uxUi = hasInterest
        notifyObservers()
    }

    private fun notifyObservers() {
        _user.value = _user.value
    }

}

