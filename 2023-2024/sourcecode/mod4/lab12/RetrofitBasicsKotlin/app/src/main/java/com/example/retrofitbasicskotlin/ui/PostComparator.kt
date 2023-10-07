package com.example.retrofitbasicskotlin.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.retrofitbasicskotlin.data.Post

class PostComparator : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}