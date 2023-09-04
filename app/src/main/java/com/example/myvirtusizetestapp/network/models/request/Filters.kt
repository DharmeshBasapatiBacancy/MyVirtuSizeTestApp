package com.example.myvirtusizetestapp.network.models.request

data class Filters(
    val attributes: Attributes,
    val brands: List<String>,
    val colors: List<String>,
    val discount: Discount,
    val fits: List<String>,
    val genders: List<String>,
    val materials: List<String>,
    val maxPrice: Int,
    val measurements: Measurements,
    val minPrice: Int,
    val occasions: List<String>,
    val productCategory: String,
    val productTypeId: Int,
    val storeIds: List<Int>,
    val styles: List<String>,
    val types: List<String>
)