package com.example.myvirtusizetestapp.network.service

import com.example.myvirtusizetestapp.network.models.request.SearchProductsRequest
import com.example.myvirtusizetestapp.network.models.response.SearchProductsResponse
import com.example.myvirtusizetestapp.utils.Resource
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("search")
    suspend fun getSearchedProductList(@Body searchProductsRequest: SearchProductsRequest,@Query("with_metas") withMetas: Boolean = true): SearchProductsResponse
}