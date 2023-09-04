package com.example.myvirtusizetestapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myvirtusizetestapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
    }
}