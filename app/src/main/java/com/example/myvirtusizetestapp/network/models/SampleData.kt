package com.example.myvirtusizetestapp.network.models

import com.example.myvirtusizetestapp.network.models.request.Criteria
import com.example.myvirtusizetestapp.network.models.request.Filters
import com.example.myvirtusizetestapp.network.models.request.Measurements
import com.example.myvirtusizetestapp.network.models.request.SearchProductsRequest

object SampleData {
    fun getSampleSearchProductsRequest(): SearchProductsRequest {
        return SearchProductsRequest(
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
    }

}