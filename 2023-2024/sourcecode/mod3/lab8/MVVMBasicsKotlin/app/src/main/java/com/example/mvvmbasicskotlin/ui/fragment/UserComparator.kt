package com.example.mvvmbasicskotlin.ui.fragment

import androidx.recyclerview.widget.DiffUtil
import com.example.mvvmbasicskotlin.model.User

class UserComparator : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}