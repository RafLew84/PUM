package com.example.mvvmbasicsjava.ui.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.mvvmbasicsjava.databinding.RvItemBinding;
import com.example.mvvmbasicsjava.model.User;

public class UserAdapter extends ListAdapter<User, UserViewHolder> {
    public UserAdapter(@NonNull DiffUtil.ItemCallback<User> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RvItemBinding binding = RvItemBinding.inflate(inflater, parent, false);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User item = getItem(position);
        holder.bind(item);
    }
}
