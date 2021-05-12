package com.lucasfagundes.androidudemycourse.utils

import android.app.Activity
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.lucasfagundes.androidudemycourse.R

fun Activity.hideKeyboard() {
    val view = currentFocus ?: View(this)
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Activity.snackBar(view: View, message: Int, length: Int) {
    Snackbar.make(view, message, length)
        .setAction("Action", null)
        .show()
}

fun Activity.setToolbarVisibility(isVisible: Boolean) {
    if (isVisible) {
        (this as AppCompatActivity).supportActionBar?.show()
    } else {
        (this as AppCompatActivity).supportActionBar?.hide()
    }
}

fun Activity.setActionBarColor(color: Int) {
    (this as AppCompatActivity).supportActionBar?.setBackgroundDrawable(
        ColorDrawable(ContextCompat.getColor(this, color)))
}

fun Activity.setStatusBarColor(color: Int) {
    val window = this.window
    window.apply {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBarColor = ContextCompat.getColor(this.context, color)
    }
}