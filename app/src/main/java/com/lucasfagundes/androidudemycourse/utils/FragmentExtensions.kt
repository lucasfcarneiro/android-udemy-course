package com.lucasfagundes.androidudemycourse.utils

import android.view.View
import androidx.fragment.app.Fragment

fun Fragment.setStatusBarColor(color: Int) {
    requireActivity().setStatusBarColor(color)
}

fun Fragment.hideKeyboard() {
    requireActivity().hideKeyboard()
}

fun Fragment.snackBar(view: View, message: Int, length: Int) {
    activity?.snackBar(view, message, length)
}

fun Fragment.setToolbarVisibility(isVisible: Boolean) {
    activity?.setToolbarVisibility(isVisible)
}
fun Fragment.setActionBarColor(color: Int){
    activity?.setActionBarColor(color)
}
