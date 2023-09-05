package com.example.myvirtusizetestapp.network.models.request

data class SearchProductsRequest(
    val criteria: Criteria,
    val filters: Filters,
    val pageFrom: Int,
    val pageSize: Int,
    val sortBy: String
)