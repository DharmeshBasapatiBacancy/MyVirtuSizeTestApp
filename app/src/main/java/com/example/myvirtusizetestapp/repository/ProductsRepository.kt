package com.example.myvirtusizetestapp.repository

import com.example.myvirtusizetestapp.network.models.request.SearchProductsRequest
import com.example.myvirtusizetestapp.network.models.response.SearchProductsResponse
import com.example.myvirtusizetestapp.network.service.ApiService
import com.example.myvirtusizetestapp.utils.Resource
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getSearchedProducts(searchProductsRequest: SearchProductsRequest): SearchProductsResponse {
        return apiService.getSearchedProductList(searchProductsRequest)
    }

}