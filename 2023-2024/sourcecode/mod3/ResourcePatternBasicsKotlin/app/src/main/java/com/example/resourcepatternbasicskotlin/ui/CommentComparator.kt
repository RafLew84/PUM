package com.example.resourcepatternbasicskotlin.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.resourcepatternbasicskotlin.data.CommentResponseItem

class CommentComparator : DiffUtil.ItemCallback<CommentResponseItem>() {
    override fun areItemsTheSame(oldItem: CommentResponseItem, newItem: CommentResponseItem): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: CommentResponseItem, newItem: CommentResponseItem): Boolean {
        return oldItem == newItem
    }
}