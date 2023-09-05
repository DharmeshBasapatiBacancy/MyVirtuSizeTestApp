package com.example.myvirtusizetestapp.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myvirtusizetestapp.databinding.RowItemSearchedProductBinding
import com.example.myvirtusizetestapp.network.models.response.Hit

class SearchProductsAdapter :
    ListAdapter<Hit, SearchProductsAdapter.ViewHolder>(callback) {

    companion object {
        val callback = object : DiffUtil.ItemCallback<Hit>() {
            override fun areItemsTheSame(
                oldItem: Hit,
                newItem: Hit
            ) =
                oldItem.externalProductId == newItem.externalProductId

            override fun areContentsTheSame(
                oldItem: Hit,
                newItem: Hit
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(val rowItemMarsBinding: RowItemSearchedProductBinding) :
        RecyclerView.ViewHolder(rowItemMarsBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        RowItemSearchedProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            rowItemMarsBinding.apply {

                val item = getItem(position)

                ivProductImage.load(item.imageUrl)
                tvProductSize.text = item.sizeName
                tvProductName.text = item.productName
                tvBrandName.text = item.brand
                tvProductPrice.text = "¥"+item.price
                if(item.availableSizes.isNotEmpty()){
                    if(item.availableSizes.size == 1){
                        tvSizeRange.text = "Size Range :" + item.availableSizes[0]
                    }else{
                        tvSizeRange.text = "Size Range :" + item.availableSizes[0] + " - " + item.availableSizes[item.availableSizes.size-1]
                    }
                }
                tvRecommendedSize.text = "Recommended Size :" + item.sizeName
            }
        }
    }

}