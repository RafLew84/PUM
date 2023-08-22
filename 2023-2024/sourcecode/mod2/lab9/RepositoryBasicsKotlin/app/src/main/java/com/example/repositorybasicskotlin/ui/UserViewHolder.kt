package com.example.repositorybasicskotlin.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.repositorybasicskotlin.databinding.RvItemBinding
import com.example.repositorybasicskotlin.model.User

class UserViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: User) {
        val fullName = "${item.firstName} ${item.lastName}"
        binding.userTextView.text = fullName
    }
}