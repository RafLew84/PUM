package pl.udu.uwr.pum.foodyjava.adapters.favorite;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import pl.udu.uwr.pum.foodyjava.adapters.MealComparator;
import pl.udu.uwr.pum.foodyjava.data.Meal;
import pl.udu.uwr.pum.foodyjava.databinding.ListItemRvBinding;

public class FavoriteAdapter extends ListAdapter<Meal, FavoriteViewHolder> {
    public FavoriteAdapter(MealComparator comparator) {
        super(comparator);
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoriteViewHolder(ListItemRvBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        Meal item = getItem(position);
        holder.bind(item);
    }

    public Meal getItemAt(int position){
        return getItem(position);
    }
}
