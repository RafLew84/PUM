package pl.udu.uwr.pum.shoppyjava.fragments.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import pl.udu.uwr.pum.shoppyjava.model.Item;

public class ItemComparator extends DiffUtil.ItemCallback<Item> {
    @Override
    public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
        return oldItem.getName().equals(newItem.getName()) &&
                oldItem.getQuantity() == newItem.getQuantity();
    }
}
