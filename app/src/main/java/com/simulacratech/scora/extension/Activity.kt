package com.simulacratech.scora.extension

import android.app.Activity
import android.view.inputmethod.InputMethodManager

fun Activity.hideSoftKeyboard() {
    try {
        val inputMethodManager = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        this.currentFocus?.let {
            inputMethodManager.hideSoftInputFromWindow(this.currentFocus!!.applicationWindowToken, 0)
        } /*?: inputMethodManager.toggleSoftInput(
                InputMethodManager.HIDE_IMPLICIT_ONLY,0
        )*/
    } catch (e: Exception) {
        e.printStackTrace()
    }
}