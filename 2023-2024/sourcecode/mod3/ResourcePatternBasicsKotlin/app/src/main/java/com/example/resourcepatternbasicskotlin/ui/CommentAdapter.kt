package com.example.resourcepatternbasicskotlin.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.resourcepatternbasicskotlin.data.CommentResponseItem
import com.example.resourcepatternbasicskotlin.databinding.RvItemBinding

class CommentAdapter(userComparator: CommentComparator) : ListAdapter<CommentResponseItem, CommentViewHolder>(userComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}