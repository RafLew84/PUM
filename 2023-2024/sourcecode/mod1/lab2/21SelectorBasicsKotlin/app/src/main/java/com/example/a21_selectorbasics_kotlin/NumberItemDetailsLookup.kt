package com.example.a21_selectorbasics_kotlin

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView

class NumberItemDetailsLookup(private val recyclerView: RecyclerView) :
    ItemDetailsLookup<Long>() {
    override fun getItemDetails(event: MotionEvent): ItemDetails<Long>?{
        val view = recyclerView.findChildViewUnder(event.x, event.y)
        return (view?.let { recyclerView.getChildViewHolder(it) } as NumberListViewHolder).getItemDetails()
    }
}