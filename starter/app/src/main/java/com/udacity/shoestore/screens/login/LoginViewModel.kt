package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel() : ViewModel() {

    var email = MutableLiveData("sonne@email.de")
    var password = MutableLiveData("")

    private var _isNavigateToWelcomePage = MutableLiveData(false)
    val isNavigateToWelcomePage: LiveData<Boolean>
        get() = _isNavigateToWelcomePage

    fun onRegister() {
        Timber.i("onRegister")
        navigateToWelcomePage()
    }

    private fun navigateToWelcomePage() {
        _isNavigateToWelcomePage.value = true
    }

    fun onLogin() {
        Timber.i("onLogin email: ${email.value}, password: ${password.value}")
        navigateToWelcomePage()
    }
}
