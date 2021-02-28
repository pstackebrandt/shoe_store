package com.udacity.shoestore.screens.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class WelcomeViewModel() : ViewModel() {

    private var _isNavigateToInstruction = MutableLiveData(false)
    val isNavigateToInstruction: LiveData<Boolean>
        get() = _isNavigateToInstruction

    fun onNavigateToInstruction() {
        Timber.i("onNavigateToInstruction")
        _isNavigateToInstruction.value = true
    }

    fun onNavigateToInstructionComplete() {
        _isNavigateToInstruction.value = false
    }
}