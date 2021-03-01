package com.udacity.shoestore.screens.shoelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

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
            Log.i("onNavigateToShoeListCom","onNavigateToShoeListComplete _isNavigateToShoeList: ${_isNavigateToShoeList.value}")
        } else {
            Timber.i("onNavigateToShoeListComplete change of _isNavigateToShoeList suppressed")
        }
    }
}