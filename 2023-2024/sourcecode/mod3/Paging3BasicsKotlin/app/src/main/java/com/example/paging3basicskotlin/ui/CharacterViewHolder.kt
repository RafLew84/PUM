package com.example.paging3basicskotlin.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.paging3basicskotlin.data.model.Result
import com.example.paging3basicskotlin.databinding.RvItemBinding

class CharacterViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Result) {
            binding.name.text = item.name
    }
}