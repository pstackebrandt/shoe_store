package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    private var _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    private var _isNavigateToShoeDetail = MutableLiveData(false)
    val isNavigateToShoeDetail: LiveData<Boolean>
        get() = _isNavigateToShoeDetail

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
            Timber.i("onNavigateToShoeDetailComplete _isNavigateToShoeDetail: ${_isNavigateToShoeDetail.value}"
            )
        } else {
            Timber.i("onNavigateToShoeDetailComplete change of _isNavigateToShoeDetail suppressed")
        }
    }
}