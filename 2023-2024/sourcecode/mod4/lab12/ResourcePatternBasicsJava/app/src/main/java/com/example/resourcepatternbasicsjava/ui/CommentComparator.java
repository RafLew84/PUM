package com.example.resourcepatternbasicsjava.ui;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.resourcepatternbasicsjava.data.CommentResponseItem;

public class CommentComparator extends DiffUtil.ItemCallback<CommentResponseItem> {
    @Override
    public boolean areItemsTheSame(@NonNull CommentResponseItem oldItem, @NonNull CommentResponseItem newItem) {
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(CommentResponseItem oldItem, @NonNull CommentResponseItem newItem) {
        return oldItem.equals(newItem);
    }
}