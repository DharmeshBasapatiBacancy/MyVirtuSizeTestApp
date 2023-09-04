package com.example.myvirtusizetestapp.network.service

import com.example.myvirtusizetestapp.network.models.request.SearchProductsRequest
import com.example.myvirtusizetestapp.network.models.response.SearchProductsResponse
import com.example.myvirtusizetestapp.utils.Resource
import retrofit2.http.POST

interface ApiService {
    @POST("search")
    suspend fun getSearchedProductList(searchProductsRequest: SearchProductsRequest): Resource<SearchProductsResponse>
}