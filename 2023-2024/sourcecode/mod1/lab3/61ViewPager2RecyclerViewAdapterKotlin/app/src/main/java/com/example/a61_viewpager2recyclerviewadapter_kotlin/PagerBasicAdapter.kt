package com.example.a61_viewpager2recyclerviewadapter_kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a61_viewpager2recyclerviewadapter_kotlin.databinding.PagerItemBinding

class PagerBasicAdapter : RecyclerView.Adapter<PagerBasicViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerBasicViewHolder {
        return PagerBasicViewHolder(
            PagerItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ))
    }

    override fun getItemCount(): Int = DataProvider.values.size

    override fun onBindViewHolder(holder: PagerBasicViewHolder, position: Int) {
        holder.bind(DataProvider.values[position])
    }
}