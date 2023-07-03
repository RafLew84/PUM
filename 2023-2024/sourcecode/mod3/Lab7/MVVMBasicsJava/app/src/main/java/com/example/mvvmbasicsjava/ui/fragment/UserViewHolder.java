package com.example.mvvmbasicsjava.ui.fragment;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmbasicsjava.databinding.RvItemBinding;
import com.example.mvvmbasicsjava.model.User;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private RvItemBinding binding;

    public UserViewHolder(RvItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(User item) {
        String fullName = item.getFirstName() + " " + item.getLastName();
        binding.wordTextView.setText(fullName);
    }
}
