package com.example.a61_viewpager2recyclerviewadapter_kotlin

import androidx.recyclerview.widget.RecyclerView
import com.example.a61_viewpager2recyclerviewadapter_kotlin.databinding.PagerItemBinding

class PagerBasicViewHolder(private val binding: PagerItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: String){
        binding.textView.text = item
    }
}