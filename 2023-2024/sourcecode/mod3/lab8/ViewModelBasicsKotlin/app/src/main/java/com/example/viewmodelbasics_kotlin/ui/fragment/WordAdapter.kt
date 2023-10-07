package com.example.viewmodelbasics_kotlin.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.viewmodelbasics_kotlin.databinding.RvItemBinding

class WordAdapter(wordComparator: WordComparator) : ListAdapter<String, WordViewHolder>(wordComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}