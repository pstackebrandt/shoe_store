package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class SharedShoeListViewModel : ViewModel() {
    private var _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

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

    fun onCancel() {
        onNavigateToShoeList()
    }

    fun onSave() {
        val currentValues: MutableList<Shoe> = _shoes.value?.toMutableList()?: mutableListOf()

        currentValues.add(
            Shoe(
                "Sport shoe",
                42.0,
                "Bayer & Pack",
                "That's a no. 1 boot"
            )
        )
        _shoes.value = currentValues
        onNavigateToShoeList()
    }

    fun onNavigateToShoeListComplete() {
        if (isNavigateToShoeList.value != false) {
            _isNavigateToShoeList.value = false
            Timber.i("onNavigateToShoeListComplete _isNavigateToShoeList: ${_isNavigateToShoeList.value}"
            )
        } else {
            Timber.i("onNavigateToShoeListComplete change of _isNavigateToShoeList suppressed")
        }
    }
}
