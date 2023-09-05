package com.example.myvirtusizetestapp.network.models.request

data class Filters(
    val gender: String,
    val productCategory: String,
    val storeIds: List<Int>
)