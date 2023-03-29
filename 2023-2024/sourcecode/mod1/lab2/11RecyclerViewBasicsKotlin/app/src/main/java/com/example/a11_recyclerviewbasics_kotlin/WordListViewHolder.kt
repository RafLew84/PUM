package com.example.a11_recyclerviewbasics_kotlin

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.a11_recyclerviewbasics_kotlin.databinding.WordListItemBinding

class WordListViewHolder(private val binding: WordListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: String) {
        binding.singleWord.text = item
        binding.root.setOnClickListener {
            val element = binding.singleWord.text
            binding.singleWord.text = "Clicked $element"
            binding.singleWord.setBackgroundColor(Color.CYAN)
        }
    }
}