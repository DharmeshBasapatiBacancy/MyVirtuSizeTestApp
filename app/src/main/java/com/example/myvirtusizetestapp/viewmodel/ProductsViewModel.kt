package com.example.myvirtusizetestapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myvirtusizetestapp.network.models.request.SearchProductsRequest
import com.example.myvirtusizetestapp.network.models.response.SearchProductsResponse
import com.example.myvirtusizetestapp.repository.ProductsRepository
import com.example.myvirtusizetestapp.utils.Resource
import com.example.myvirtusizetestapp.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val productsRepository: ProductsRepository): ViewModel() {

    private val _searchProductsResponse = MutableLiveData<SearchProductsResponse>()
    val searchProductsResponse: LiveData<SearchProductsResponse> = _searchProductsResponse

    fun getSearchedProducts(searchProductsRequest: SearchProductsRequest){
        viewModelScope.launch {
            _searchProductsResponse.value = productsRepository.getSearchedProducts(searchProductsRequest)
        }
    }
}