package com.example.resourcepatternbasicskotlin.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.resourcepatternbasicskotlin.data.CommentResponseItem
import com.example.resourcepatternbasicskotlin.databinding.RvItemBinding

class CommentViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CommentResponseItem) {
        binding.apply {
            title.text = item.name
            body.text = item.body
            commentId.text = item.postId.toString()
        }
    }
}