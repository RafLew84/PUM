package pl.udu.uwr.pum.foodyjava.adapters.meallist;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import pl.udu.uwr.pum.foodyjava.data.Meal;
import pl.udu.uwr.pum.foodyjava.databinding.ListItemRvBinding;

public class MealViewHolder extends RecyclerView.ViewHolder {
    private final ListItemRvBinding binding;
    public MealViewHolder(ListItemRvBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Meal item){
        binding.name.setText(item.strMeal);
        Glide.with(binding.getRoot())
                .load(item.strMealThumb)
                .into(binding.image);
    }
}
