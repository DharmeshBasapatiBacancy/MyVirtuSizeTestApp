package com.example.myvirtusizetestapp.network.models.response

data class SearchProductsResponse(
    val distinct_brands: Int,
    val hits: List<Hit>,
    val total_hits: Int
)