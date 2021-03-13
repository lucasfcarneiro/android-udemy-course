package com.lucasfagundes.androidudemycourse.feature.beer_values.utils

import android.widget.EditText

fun EditText.toPrice(): Double {
    return this.text.toString().toDouble()
}