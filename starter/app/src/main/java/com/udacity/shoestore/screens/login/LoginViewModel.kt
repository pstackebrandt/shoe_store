package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel : ViewModel() {

    var email = MutableLiveData("sonne@email.de")
    var password = MutableLiveData("")

    private var _isNavigateToWelcome = MutableLiveData(false)
    val isNavigateToWelcome: LiveData<Boolean>
        get() = _isNavigateToWelcome

    fun onLogin() {
        Timber.i("onLogin email: ${email.value}, password: ${password.value}")
        navigateToWelcome()
    }

    fun onRegister() {
        Timber.i("onRegister")
        navigateToWelcome()
    }

    private fun navigateToWelcome() {
        _isNavigateToWelcome.value = true
    }

    fun onNavigateToWelcomeComplete() {
        if (isNavigateToWelcome.value == true) {
            _isNavigateToWelcome.value = false
        }
    }
}
