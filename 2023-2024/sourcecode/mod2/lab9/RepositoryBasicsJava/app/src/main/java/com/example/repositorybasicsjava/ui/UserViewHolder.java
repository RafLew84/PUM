package com.example.repositorybasicsjava.ui;

import androidx.recyclerview.widget.RecyclerView;

import com.example.repositorybasicsjava.databinding.RvItemBinding;
import com.example.repositorybasicsjava.model.User;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private RvItemBinding binding;

    public UserViewHolder(RvItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(User item) {
        String fullName = item.getFirstName() + " " + item.getLastName();
        binding.userTextView.setText(fullName);
    }
}
