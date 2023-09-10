package com.example.roombasicsjava.ui;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roombasicsjava.data.User;
import com.example.roombasicsjava.databinding.RvItemBinding;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private RvItemBinding binding;

    public UserViewHolder(RvItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(User item) {
        binding.textView.setText(item.getFirstName() + " " + item.getLastName());
    }
}
