package com.example.myvirtusizetestapp.utils

import android.view.View

object ViewExtensions {

    fun View.visible() {
        visibility = View.VISIBLE
    }

    fun View.invisible() {
        visibility = View.INVISIBLE
    }

    fun View.gone() {
        visibility = View.GONE
    }

}