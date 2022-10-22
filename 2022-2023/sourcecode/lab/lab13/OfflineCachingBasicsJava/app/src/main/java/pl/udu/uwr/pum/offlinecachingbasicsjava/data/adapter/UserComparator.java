package pl.udu.uwr.pum.offlinecachingbasicsjava.data.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import pl.udu.uwr.pum.offlinecachingbasicsjava.data.User;

public class UserComparator extends DiffUtil.ItemCallback<User> {
    @Override
    public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
        return newItem.getUid().equals(oldItem.getUid());
    }

    @Override
    public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
        return newItem.getId() == oldItem.getId();
    }
}
