package com.lucasfagundes.androidudemycourse.feature.my_annotations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasfagundes.androidudemycourse.data.SharedPreferenceHelper

const val NOTE_KEY = "note"

class MyAnnotationViewModel(private val sharedPreferenceHelper: SharedPreferenceHelper) :
    ViewModel() {

    val note: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val error: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    init {
        note.value = sharedPreferenceHelper.getStringFromPreferences(NOTE_KEY)
    }

    fun saveStringOnPreference(string: String) {
        if (string.isNotEmpty()) {
            sharedPreferenceHelper.saveStringOnPreferences(NOTE_KEY, string)
            error.value = false
        } else {
            error.value = true
        }
    }
}