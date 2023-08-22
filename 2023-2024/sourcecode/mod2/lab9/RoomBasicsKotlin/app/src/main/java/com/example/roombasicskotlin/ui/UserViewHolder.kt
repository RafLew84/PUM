package com.example.roombasicskotlin.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.roombasicskotlin.data.User
import com.example.roombasicskotlin.databinding.RvItemBinding

class UserViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: User) {
        binding.textView.text = "${item.firstName} ${item.lastName}"
    }
}