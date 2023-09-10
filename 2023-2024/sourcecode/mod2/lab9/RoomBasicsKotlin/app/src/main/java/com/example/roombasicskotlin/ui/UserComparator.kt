package com.example.roombasicskotlin.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.roombasicskotlin.data.User

class UserComparator : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}