package com.lucasfagundes.androidudemycourse.feature.random_number

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.common.extensions.getString
import kotlin.random.Random

class RandomNumberViewModel(application: Application) : AndroidViewModel(application) {

    val randomNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val result: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun setRandomNumber() {
        randomNumber.value = Random.nextInt(0, 20)
        result.value = getString(R.string.number_answer, randomNumber.toString())
    }
}