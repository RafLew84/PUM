package com.example.repositorybasicskotlin.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.repositorybasicskotlin.model.User

class UserComparator : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}