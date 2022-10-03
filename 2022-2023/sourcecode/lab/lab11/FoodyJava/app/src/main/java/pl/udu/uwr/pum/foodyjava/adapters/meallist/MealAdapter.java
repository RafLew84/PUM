package pl.udu.uwr.pum.foodyjava.adapters.meallist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import pl.udu.uwr.pum.foodyjava.adapters.MealComparator;
import pl.udu.uwr.pum.foodyjava.data.Meal;
import pl.udu.uwr.pum.foodyjava.databinding.ListItemRvBinding;

public class MealAdapter extends ListAdapter<Meal, MealViewHolder> {
    public MealAdapter(MealComparator comparator) {
        super(comparator);
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MealViewHolder(ListItemRvBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Meal item = getItem(position);
        holder.bind(item);
    }
}
