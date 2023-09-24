package com.example.a22_selectionbasics_java;

import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

public class NumberItemDetailsLookup extends ItemDetailsLookup<Long> {

    private final RecyclerView recyclerView;

    public NumberItemDetailsLookup(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public ItemDetails<Long> getItemDetails(@NonNull MotionEvent e) {
        View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
        return ((NumberListViewHolder)recyclerView
                .getChildViewHolder(view)).getItemDetails();
    }
}
