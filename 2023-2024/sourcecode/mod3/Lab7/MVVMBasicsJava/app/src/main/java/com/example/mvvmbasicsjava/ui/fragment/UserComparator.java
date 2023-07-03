package com.example.mvvmbasicsjava.ui.fragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.mvvmbasicsjava.model.User;

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
