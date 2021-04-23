package com.lucasfagundes.androidudemycourse.utils

import androidx.fragment.app.Fragment

fun Fragment.changeStatusBarColor(color: Int){
    requireActivity().changeStatusBarColor(color)
}

fun Fragment.hideKeyboard() {
    requireActivity().hideKeyboard()
}
