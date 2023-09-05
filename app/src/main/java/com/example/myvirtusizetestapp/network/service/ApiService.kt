package com.example.myvirtusizetestapp.network.service

import com.example.myvirtusizetestapp.network.models.request.SearchProductsRequest
import com.example.myvirtusizetestapp.network.models.response.SearchProductsResponse
import com.example.myvirtusizetestapp.utils.Constants.SEARCH_ENDPOINT
import com.example.myvirtusizetestapp.utils.Constants.WITH_METAS
import com.example.myvirtusizetestapp.utils.Resource
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST(SEARCH_ENDPOINT)
    suspend fun getSearchedProductList(@Body searchProductsRequest: SearchProductsRequest,@Query(WITH_METAS) withMetas: Boolean = true): SearchProductsResponse
}