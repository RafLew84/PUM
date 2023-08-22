package com.example.retrofitbasicsjava.ui;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.retrofitbasicsjava.data.Post;

public class PostComparator extends DiffUtil.ItemCallback<Post> {
    @Override
    public boolean areItemsTheSame(@NonNull Post oldItem, @NonNull Post newItem) {
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(Post oldItem, @NonNull Post newItem) {
        return oldItem.equals(newItem);
    }
}
