package com.example.myvirtusizetestapp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myvirtusizetestapp.databinding.ActivityProductListBinding
import com.example.myvirtusizetestapp.network.models.SampleData.getSampleSearchProductsRequest
import com.example.myvirtusizetestapp.view.adapters.SearchProductsAdapter
import com.example.myvirtusizetestapp.viewmodel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListActivity : AppCompatActivity() {

    private lateinit var searchProductsAdapter: SearchProductsAdapter
    private lateinit var binding: ActivityProductListBinding
    private val productsViewModel: ProductsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupProductsRecyclerView()

        productsViewModel.searchProductsResponse.observe(this@ProductListActivity){
            binding.lnrLayoutForButton.visibility = View.GONE
            searchProductsAdapter.submitList(it.hits)
        }

        setupClickListener()
    }

    private fun setupClickListener() {
        binding.btnSearchProducts.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            binding.btnSearchProducts.visibility = View.GONE
            productsViewModel.getSearchedProducts(getSampleSearchProductsRequest())
        }
    }

    private fun setupProductsRecyclerView() {
        binding.apply {
            rvProducts.layoutManager = GridLayoutManager(this@ProductListActivity,2)
            searchProductsAdapter = SearchProductsAdapter()
            rvProducts.adapter = searchProductsAdapter
        }
    }

}