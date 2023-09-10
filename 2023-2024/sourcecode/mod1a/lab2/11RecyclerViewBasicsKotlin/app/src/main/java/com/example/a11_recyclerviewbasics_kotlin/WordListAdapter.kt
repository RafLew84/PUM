package com.example.a11_recyclerviewbasics_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a11_recyclerviewbasics_kotlin.databinding.WordListItemBinding

class WordListAdapter(private val wordList: MutableList<String>) :
    RecyclerView.Adapter<WordListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordListViewHolder {
        return WordListViewHolder(
            WordListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ))

    }

    override fun getItemCount(): Int = wordList.size

    override fun onBindViewHolder(holder: WordListViewHolder, position: Int) {
        val currentItem = wordList[position]
        holder.bind(currentItem)
    }

}