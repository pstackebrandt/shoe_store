package com.udacity.shoestore.screens.instruction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class InstructionViewModel : ViewModel() {

    private var _isNavigateToShoeList = MutableLiveData(false)
    val isNavigateToShoeList: LiveData<Boolean>
        get() = _isNavigateToShoeList

    fun onNavigateToShoeList() {
        if (isNavigateToShoeList.value != true) {
            Timber.i("onNavigateToShoeList: value changed")
            _isNavigateToShoeList.value = true
        } else {
            Timber.i("onNavigateToShoeList: value change suppressed")
        }
    }

    fun onNavigateToShoeListComplete() {
        if (isNavigateToShoeList.value != false) {
            _isNavigateToShoeList.value = false
            Timber.i("onNavigateToShoeListComplete _isNavigateToShoeList: ${_isNavigateToShoeList.value}")
            Timber.i( "Timber.treeCount(): ${Timber.treeCount()}")
        } else {
            Timber.i("onNavigateToShoeListComplete change of _isNavigateToShoeList suppressed")
        }
    }
}