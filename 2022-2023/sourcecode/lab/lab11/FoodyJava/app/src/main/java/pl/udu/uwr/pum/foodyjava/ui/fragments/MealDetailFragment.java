package pl.udu.uwr.pum.foodyjava.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import pl.udu.uwr.pum.foodyjava.R;
import pl.udu.uwr.pum.foodyjava.data.Meal;
import pl.udu.uwr.pum.foodyjava.databinding.FragmentMealDetailBinding;
import pl.udu.uwr.pum.foodyjava.databinding.FragmentMealListBinding;
import pl.udu.uwr.pum.foodyjava.ui.MealViewModel;

public class MealDetailFragment extends Fragment {

    private FragmentMealDetailBinding binding;
    private MealViewModel viewModel;

    private String id;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMealDetailBinding.inflate(inflater, container, false);
        id = requireArguments().getString("id");
        viewModel = new ViewModelProvider(requireActivity()).get(MealViewModel.class);
        viewModel.getMealById(id);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.getMeal().observe(getViewLifecycleOwner(), mealResponse -> {
            mealResponse.meals.stream().findFirst().ifPresent(this::inflate);
            binding.favoriteButton.setOnClickListener(v -> {
                viewModel.insert(mealResponse.meals.stream().findFirst().orElse(null));
            });
        });
    }

    private void inflate(Meal item){
        Glide.with(this)
                .load(item.strMealThumb)
                .into(binding.foodImage);
        binding.category.setText(item.strCategory);
        binding.title.setText(item.strMeal);
        binding.instructions.setText(item.strInstructions);
    }
}