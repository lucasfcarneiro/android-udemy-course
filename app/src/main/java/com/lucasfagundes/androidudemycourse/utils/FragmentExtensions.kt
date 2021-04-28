package com.lucasfagundes.androidudemycourse.utils

import android.view.View
import androidx.fragment.app.Fragment

fun Fragment.changeStatusBarColor(color: Int) {
    requireActivity().changeStatusBarColor(color)
}

fun Fragment.hideKeyboard() {
    requireActivity().hideKeyboard()
}

fun Fragment.snackBar(view: View, message: Int, length: Int) {
    activity?.snackBar(view, message, length)
}
