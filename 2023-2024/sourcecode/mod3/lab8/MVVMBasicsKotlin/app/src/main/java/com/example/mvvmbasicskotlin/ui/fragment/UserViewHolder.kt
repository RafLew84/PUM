package com.example.mvvmbasicskotlin.ui.fragment

import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmbasicskotlin.databinding.RvItemBinding
import com.example.mvvmbasicskotlin.model.User

class UserViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: User) {
        val fullName = "${item.firstName} ${item.lastName}"
        binding.wordTextView.text = fullName
    }
}