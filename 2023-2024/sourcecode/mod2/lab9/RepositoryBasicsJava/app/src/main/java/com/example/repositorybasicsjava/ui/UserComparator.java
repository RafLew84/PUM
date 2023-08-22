package com.example.repositorybasicsjava.ui;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.repositorybasicsjava.model.User;

public class UserComparator extends DiffUtil.ItemCallback<User> {
    @Override
    public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(User oldItem, @NonNull User newItem) {
        return oldItem.equals(newItem);
    }
}
