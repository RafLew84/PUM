package com.example.roombasicsjava.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.roombasicsjava.data.User;
import com.example.roombasicsjava.databinding.RvItemBinding;

public class UserAdapter extends ListAdapter<User, UserViewHolder> {
    public UserAdapter(@NonNull DiffUtil.ItemCallback<User> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(
                RvItemBinding.inflate(
                        LayoutInflater.from(parent.getContext()), parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User item = getItem(position);
        holder.bind(item);
    }
}
