package com.example.myvirtusizetestapp.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import android.view.LayoutInflater
import android.widget.TextView


/**
 * Created by Waheed on 04,November,2019
 */

object ToastUtil {

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}