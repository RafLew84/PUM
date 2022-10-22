package pl.udu.uwr.pum.offlinecachingbasicsjava.data.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import pl.udu.uwr.pum.offlinecachingbasicsjava.data.User;
import pl.udu.uwr.pum.offlinecachingbasicsjava.databinding.RvItemBinding;

public class UserAdapter extends ListAdapter<User, UserViewHolder> {
    public UserAdapter(UserComparator comparator) {
        super(comparator);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(RvItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User item = getItem(position);
        holder.bind(item);
    }
}
