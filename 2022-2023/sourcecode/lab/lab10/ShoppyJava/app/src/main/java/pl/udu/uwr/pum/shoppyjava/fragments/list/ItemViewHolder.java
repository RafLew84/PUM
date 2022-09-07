package pl.udu.uwr.pum.shoppyjava.fragments.list;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import pl.udu.uwr.pum.shoppyjava.model.Item;
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

        binding.getRoot().setOnClickListener(v -> {
            NavDirections action = ListFragmentDirections
                    .actionListFragmentToUpdateFragment(item.getId());
            Navigation.findNavController(binding.getRoot()).navigate(action);
        });
    }
}
