package com.example.viewmodelbasics_kotlin.ui.fragment

import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelbasics_kotlin.databinding.RvItemBinding

class WordViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: String) {
        binding.wordTextView.text = item
    }
}