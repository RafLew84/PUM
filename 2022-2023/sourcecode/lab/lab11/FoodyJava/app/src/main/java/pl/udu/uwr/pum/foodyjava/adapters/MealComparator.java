package pl.udu.uwr.pum.foodyjava.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import pl.udu.uwr.pum.foodyjava.data.Meal;

public class MealComparator extends DiffUtil.ItemCallback<Meal> {
    @Override
    public boolean areItemsTheSame(@NonNull Meal oldItem, @NonNull Meal newItem) {
        return newItem.idMeal.equals(oldItem.idMeal);
    }

    @Override
    public boolean areContentsTheSame(@NonNull Meal oldItem, @NonNull Meal newItem) {
        return newItem.strMeal.equals(oldItem.strMeal);
    }
}
