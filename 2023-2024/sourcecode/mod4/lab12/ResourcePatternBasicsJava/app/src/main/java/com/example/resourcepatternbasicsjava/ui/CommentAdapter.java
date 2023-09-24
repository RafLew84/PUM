package com.example.resourcepatternbasicsjava.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import com.example.resourcepatternbasicsjava.data.CommentResponseItem;
import com.example.resourcepatternbasicsjava.databinding.RvItemBinding;

public class CommentAdapter extends ListAdapter<CommentResponseItem, CommentViewHolder> {
    public CommentAdapter(CommentComparator userComparator) {
        super(userComparator);
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RvItemBinding binding = RvItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CommentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        CommentResponseItem item = getItem(position);
        holder.bind(item);
    }
}
