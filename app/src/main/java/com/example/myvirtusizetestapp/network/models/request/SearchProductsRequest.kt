package com.example.myvirtusizetestapp.network.models.request

data class SearchProductsRequest(
    val collapseVariants: Boolean,
    val criteria: Criteria,
    val customEsWeights: CustomEsWeights,
    val filters: Filters,
    val pageFrom: Int,
    val pageSize: Int,
    val sortBy: String,
    val storeProductId: Int
)