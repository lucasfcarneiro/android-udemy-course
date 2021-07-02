package com.lucasfagundes.androidudemycourse.common.extensions

import android.app.Application
import androidx.lifecycle.AndroidViewModel

fun AndroidViewModel.getString(int: Int, string: String? = null): String =
    if (string.isNullOrBlank()) {
        getApplication<Application>().resources.getString(int)
    } else {
        getApplication<Application>().resources.getString(int, string)
    }