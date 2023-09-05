package com.example.myvirtusizetestapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.myvirtusizetestapp.R
import com.example.myvirtusizetestapp.network.models.request.Criteria
import com.example.myvirtusizetestapp.network.models.request.Filters
import com.example.myvirtusizetestapp.network.models.request.Measurements
import com.example.myvirtusizetestapp.network.models.request.SearchProductsRequest
import com.example.myvirtusizetestapp.viewmodel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListActivity : AppCompatActivity() {

    private val productsViewModel: ProductsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val searchProductsRequest = SearchProductsRequest(
            sortBy = "fitScore",
            pageSize = 6,
            pageFrom = 0,
            criteria = Criteria(
                measurements = Measurements(
                    height = 700,
                    bust = 540
                )
            ),
            filters = Filters(
                gender = "female",
                storeIds = listOf(535),
                productCategory = "tops"
            )
        )
        productsViewModel.getSearchedProducts(searchProductsRequest)
        productsViewModel.searchProductsResponse.observe(this){
            Log.d(Companion.TAG, "onCreate: ON SEARCH PRODUCTS RESPONSE = $it")
        }
    }

    companion object {
        private const val TAG = "ProductListActivity"
    }
}