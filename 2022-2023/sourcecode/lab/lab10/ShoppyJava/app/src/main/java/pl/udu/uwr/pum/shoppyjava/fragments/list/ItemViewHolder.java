package pl.udu.uwr.pum.shoppyjava.fragments.list;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import pl.udu.uwr.pum.shoppyjava.data.Item;
import pl.udu.uwr.pum.shoppyjava.databinding.ItemRecyclerviewBinding;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private final ItemRecyclerviewBinding binding;

    public ItemViewHolder(@NonNull ItemRecyclerviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Item item){
        binding.nameTextViewRV.setText(item.getName());
        binding.quantityTextViewRV.setText(String.valueOf(item.getQuantity()));
    }
}
