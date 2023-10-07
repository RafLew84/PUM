package com.example.retrofitbasicskotlin.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitbasicskotlin.data.Post
import com.example.retrofitbasicskotlin.databinding.RvItemBinding

class PostViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Post) {
        binding.apply {
            title.text = item.title
            content.text = item.content
            userId.text = item.userId.toString()
        }
    }
}