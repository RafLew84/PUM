package com.example.paging3basicskotlin.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.paging3basicskotlin.data.model.Result

class CharacterComparator : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }
}