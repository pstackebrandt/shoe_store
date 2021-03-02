package com.udacity.shoestore.screens.shoelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    private var _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    private var _isNavigateToShoeList = MutableLiveData(false)
    val isNavigateToShoeList: LiveData<Boolean>
        get() = _isNavigateToShoeList

    init {
        val shoes = mutableListOf<Shoe>()
        shoes.add(Shoe("Roman sandals", 40.5, "New Caesar's", "Ancient shoes for sunny days."))
        shoes.add(Shoe("Peter's big shoes", 41.0, "Moon & Pack", "Hold you warm at -20° Celsius"))

        repeat(10) {
            shoes.add(
                Shoe(
                    "Sport shoe $it",
                    41.0 + it,
                    "Moon & Pack",
                    "That's a no. $it boot"
                )
            )
        }
        _shoes.value = shoes
    }

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
            Log.i(
                "onNavigateToShoeListCom",
                "onNavigateToShoeListComplete _isNavigateToShoeList: ${_isNavigateToShoeList.value}"
            )
        } else {
            Timber.i("onNavigateToShoeListComplete change of _isNavigateToShoeList suppressed")
        }
    }
}