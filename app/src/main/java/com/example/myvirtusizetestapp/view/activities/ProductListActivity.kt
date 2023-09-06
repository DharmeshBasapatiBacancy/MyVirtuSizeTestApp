package com.example.myvirtusizetestapp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myvirtusizetestapp.R
import com.example.myvirtusizetestapp.databinding.ActivityProductListBinding
import com.example.myvirtusizetestapp.network.models.SampleData.getSampleSearchProductsRequest
import com.example.myvirtusizetestapp.utils.CommonUtils.isOnline
import com.example.myvirtusizetestapp.utils.ToastUtil.showToast
import com.example.myvirtusizetestapp.utils.ViewExtensions.gone
import com.example.myvirtusizetestapp.utils.ViewExtensions.visible
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
            binding.lnrLayoutForButton.gone()
            searchProductsAdapter.submitList(it.hits)
        }

        setupClickListener()
    }

    private fun setupClickListener() {
        binding.btnSearchProducts.setOnClickListener {
            if(isOnline(this)){
                binding.progressBar.visible()
                binding.btnSearchProducts.gone()
                productsViewModel.getSearchedProducts(getSampleSearchProductsRequest())
            }else{
                showToast(this, getString(R.string.msg_no_internet_connection))
            }
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