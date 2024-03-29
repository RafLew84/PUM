package com.example.viewmodelbasicsjava.ui.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import com.example.viewmodelbasicsjava.databinding.RvItemBinding;

public class WordAdapter extends ListAdapter<String, WordViewHolder> {
    protected WordAdapter(WordComparator comparator) {
        super(comparator);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WordViewHolder(RvItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String item = getItem(position);
        holder.bind(item);
    }
}