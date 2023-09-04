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

    private val _searchProductsResponse = MutableLiveData<Resource<SearchProductsResponse>>()
    val searchProductsResponse: LiveData<Resource<SearchProductsResponse>> = _searchProductsResponse

    fun getSearchedProducts(searchProductsRequest: SearchProductsRequest){
        _searchProductsResponse.value = Resource.loading(null)
        viewModelScope.launch {

            val apiResponse = productsRepository.getSearchedProducts(searchProductsRequest)
            when(apiResponse.status){
                Status.SUCCESS -> {
                    Log.d(TAG, "getSearchedProducts: ON SUCCESS")
                }
                Status.ERROR -> {
                    Log.d(TAG, "getSearchedProducts: ON ERROR")
                }
                Status.LOADING -> {
                    Log.d(TAG, "getSearchedProducts: ON LOADING")
                }
            }

        }
    }

    companion object {
        private const val TAG = "ProductsViewModel"
    }
}