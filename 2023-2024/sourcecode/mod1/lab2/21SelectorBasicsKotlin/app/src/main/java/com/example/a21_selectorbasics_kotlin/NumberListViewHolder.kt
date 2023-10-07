package com.example.a21_selectorbasics_kotlin

import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.a21_selectorbasics_kotlin.databinding.ActivityMainBinding
import com.example.a21_selectorbasics_kotlin.databinding.RvItemBinding

class NumberListViewHolder(private val binding: RvItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(value: Int, isActivated: Boolean = false) {
        binding.numberText.text = value.toString()
        binding.root.isActivated = isActivated
    }

    fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
        object : ItemDetailsLookup.ItemDetails<Long>() {
            override fun getPosition(): Int = adapterPosition
            override fun getSelectionKey(): Long = itemId
        }
}