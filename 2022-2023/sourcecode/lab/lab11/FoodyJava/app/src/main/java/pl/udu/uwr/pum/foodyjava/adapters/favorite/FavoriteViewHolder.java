package pl.udu.uwr.pum.foodyjava.adapters.favorite;

import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import pl.udu.uwr.pum.foodyjava.data.Meal;
import pl.udu.uwr.pum.foodyjava.databinding.ListItemRvBinding;
import pl.udu.uwr.pum.foodyjava.ui.fragments.FavoriteFragmentDirections;
import pl.udu.uwr.pum.foodyjava.ui.fragments.MealListFragmentDirections;

public class FavoriteViewHolder extends RecyclerView.ViewHolder {
    private final ListItemRvBinding binding;
    public FavoriteViewHolder(ListItemRvBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Meal item){
        binding.name.setText(item.strMeal);
        Glide.with(binding.getRoot())
                .load(item.strMealThumb)
                .into(binding.image);
        binding.getRoot().setOnClickListener(view -> {
            NavDirections action = FavoriteFragmentDirections
                    .actionFavoriteFragmentToMealDetailFragment(
                            item.idMeal
                    );
            Navigation.findNavController(binding.getRoot()).navigate(action);
        });
    }
}
