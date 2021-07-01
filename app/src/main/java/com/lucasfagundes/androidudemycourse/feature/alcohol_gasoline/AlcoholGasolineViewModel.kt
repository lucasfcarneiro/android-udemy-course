package com.lucasfagundes.androidudemycourse.feature.alcohol_gasoline

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.common.extensions.getString

private const val FUEL_PERCENTAGE_RULE = 0.7

class AlcoholGasolineViewModel(application: Application) : AndroidViewModel(application) {

    val result: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val comparison: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun compareFuelPrices(alcoholPrice: String, gasolinePrice: String) {
        val isFieldValidated = validateFields(alcoholPrice, gasolinePrice)

        if (isFieldValidated) {
            val fuelDivision = alcoholPrice.toDouble() / gasolinePrice.toDouble()
            if (fuelDivision <= FUEL_PERCENTAGE_RULE) {
                result.value = getString(R.string.better_alcohol)
            } else {
                result.value = getString(R.string.better_gasoline)
            }
            comparison.value = getString(R.string.fuel_price_comparison, fuelDivision.toString())
        }else{
            result.value = getString(R.string.empty_field)
        }
    }

    private fun validateFields(alcoholPrice: String, gasolinePrice: String): Boolean {
        var isValid = true

        if (alcoholPrice.isBlank()) {
            isValid = false
        } else if (gasolinePrice.isBlank()) {
            isValid = false
        }
        return isValid
    }
}