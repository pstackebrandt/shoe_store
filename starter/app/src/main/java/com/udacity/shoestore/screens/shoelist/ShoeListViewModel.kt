package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    private var _isNavigateToShoeDetail = MutableLiveData(false)
    val isNavigateToShoeDetail: LiveData<Boolean>
        get() = _isNavigateToShoeDetail


    fun onNavigateToShoeDetail() {
        if (isNavigateToShoeDetail.value != true) {
            Timber.i("onNavigateToShoeList: value changed")
            _isNavigateToShoeDetail.value = true
        } else {
            Timber.i("onNavigateToShoeList: value change suppressed")
        }
    }

    fun onNavigateToShoeDetailComplete() {
        if (isNavigateToShoeDetail.value != false) {
            _isNavigateToShoeDetail.value = false
            Timber.i(
                "onNavigateToShoeDetailComplete _isNavigateToShoeDetail: ${_isNavigateToShoeDetail.value}"
            )
        } else {
            Timber.i("onNavigateToShoeDetailComplete change of _isNavigateToShoeDetail suppressed")
        }
    }
}