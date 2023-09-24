package com.example.a22_selectionbasics_java;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a22_selectionbasics_java.databinding.RvItemBinding;

import java.util.LinkedList;

public class NumberListAdapter extends RecyclerView.Adapter<NumberListViewHolder>{

    private final LinkedList<Integer> numberList;

    private SelectionTracker<Long> selectionTracker;
    public void setSelectionTracker(SelectionTracker<Long> selectionTracker) {
        this.selectionTracker = selectionTracker;
    }

    public NumberListAdapter(LinkedList<Integer> numberList){
        this.numberList = numberList;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public NumberListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NumberListViewHolder(RvItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull NumberListViewHolder holder, int position) {
        holder.bind(
                numberList.get(position),
                selectionTracker.isSelected((long)position));
    }

    @Override
    public int getItemCount() {
        return numberList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
