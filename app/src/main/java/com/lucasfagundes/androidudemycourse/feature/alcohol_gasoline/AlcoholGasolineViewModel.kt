package com.lucasfagundes.androidudemycourse.feature.alcohol_gasoline

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AlcoholGasolineViewModel : ViewModel(){

    val gasoline: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val alcohol: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val error: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun getPrices(){

    }
}