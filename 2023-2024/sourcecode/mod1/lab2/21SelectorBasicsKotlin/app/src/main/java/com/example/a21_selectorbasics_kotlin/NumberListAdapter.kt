package com.example.a21_selectorbasics_kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.example.a21_selectorbasics_kotlin.databinding.RvItemBinding

class NumberListAdapter(
    private val numberList: List<Int>,
) : RecyclerView.Adapter<NumberListViewHolder>() {

    lateinit var selectionTracker: SelectionTracker<Long>

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NumberListViewHolder {
        return NumberListViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ))
    }

    override fun onBindViewHolder(holder: NumberListViewHolder, position: Int) {
        holder.bind(numberList[position], selectionTracker.isSelected(position.toLong()))
    }

    override fun getItemCount() = numberList.size
    override fun getItemId(position: Int): Long = position.toLong()
}