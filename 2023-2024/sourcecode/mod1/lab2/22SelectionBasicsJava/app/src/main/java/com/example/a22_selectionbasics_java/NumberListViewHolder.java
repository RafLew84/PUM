package com.example.a22_selectionbasics_java;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a22_selectionbasics_java.databinding.RvItemBinding;

class NumberListViewHolder extends RecyclerView.ViewHolder {

    private final RvItemBinding binding;
    public NumberListViewHolder(RvItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(int value, boolean isActivated){
        binding.numberText.setText(String.valueOf(value));
        binding.getRoot().setActivated(isActivated);
    }

    public ItemDetailsLookup.ItemDetails<Long> getItemDetails() {
        return new ItemDetailsLookup.ItemDetails<Long>() {
            @Override
            public int getPosition() {
                return getAdapterPosition();
            }

            @NonNull
            @Override
            public Long getSelectionKey() {
                return getItemId();
            }
        };
    }
}
