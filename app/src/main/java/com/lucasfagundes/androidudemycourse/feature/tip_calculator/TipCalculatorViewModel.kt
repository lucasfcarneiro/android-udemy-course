package com.lucasfagundes.androidudemycourse.feature.tip_calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TipCalculatorViewModel() : ViewModel() {

    val percentage: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }
    val billvalue: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }


    fun calculateTip() {
        val tip = billvalue.value * (percentage.value / 100)

    }

}