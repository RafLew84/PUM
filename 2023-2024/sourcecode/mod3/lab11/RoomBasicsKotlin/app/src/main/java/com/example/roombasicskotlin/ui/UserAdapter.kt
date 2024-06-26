package com.example.roombasicskotlin.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.roombasicskotlin.data.User
import com.example.roombasicskotlin.databinding.RvItemBinding

class UserAdapter(userComparator: UserComparator) : ListAdapter<User, UserViewHolder>(userComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}