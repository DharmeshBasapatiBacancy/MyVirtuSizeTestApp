package com.example.myvirtusizetestapp.network.models.response

data class Hit(
    val availableSizes: List<String>,
    val bottomsFit: String,
    val bottomsLength: String,
    val bottomsType: String,
    val brand: String,
    val brandHash: String,
    val category: String,
    val cloudinaryPublicId: String,
    val color: String,
    val currency: String,
    val discount: Int,
    val esScore: Int,
    val externalProductId: String,
    val fit: String,
    val gender: String,
    val imageUrl: String,
    val materials: String,
    val necklineType: String,
    val occasion: String,
    val originalBrand: String,
    val originalColor: String,
    val originalPrice: Int,
    val others: Others,
    val overclothesClosure: String,
    val overclothesNecklineType: String,
    val overclothesType: String,
    val pattern: String,
    val price: Int,
    val productName: String,
    val productTypeId: Int,
    val productTypeName: String,
    val sizeMeasurements: SizeMeasurements,
    val sizeName: String,
    val skirtLength: String,
    val skirtType: String,
    val sku: String,
    val sleeveLength: String,
    val sleeveType: String,
    val storeId: Int,
    val storeName: String,
    val storeProductId: Int,
    val style: String,
    val tankType: String,
    val topsFit: String,
    val topsLength: String,
    val type: String,
    val url: String,
    val virtualItem: VirtualItem,
    val waistType: String
)