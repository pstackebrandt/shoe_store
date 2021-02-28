package com.udacity.shoestore.screens.login

import android.util.Log

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel() : ViewModel() {

    fun onRegister() {
        Timber.i("onRegister")
    }

    fun onLogin() {
        Timber.i("onLogin")
    }
}
