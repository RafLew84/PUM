package com.example.paging3basicskotlin.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.paging3basicskotlin.data.model.Result
import com.example.paging3basicskotlin.databinding.RvItemBinding

class CharacterAdapter(characterComparator: CharacterComparator) : PagingDataAdapter<Result, CharacterViewHolder>(characterComparator) {
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = getItem(position) ?: Result("", "", "")
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
}