package com.lucasfagundes.androidudemycourse.utils

import android.widget.EditText

fun EditText.toPrice(): Double {
    return this.text.toString().toDouble()
}