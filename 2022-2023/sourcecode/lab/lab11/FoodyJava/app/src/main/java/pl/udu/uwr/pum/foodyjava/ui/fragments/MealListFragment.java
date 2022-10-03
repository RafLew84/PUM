package pl.udu.uwr.pum.foodyjava.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import pl.udu.uwr.pum.foodyjava.adapters.MealComparator;
import pl.udu.uwr.pum.foodyjava.adapters.meallist.MealAdapter;
import pl.udu.uwr.pum.foodyjava.adapters.meallist.MealViewHolder;
import pl.udu.uwr.pum.foodyjava.databinding.FragmentMealListBinding;
import pl.udu.uwr.pum.foodyjava.ui.MainActivity;
import pl.udu.uwr.pum.foodyjava.ui.MealViewModel;

public class MealListFragment extends Fragment {

    private FragmentMealListBinding binding;
    private MealViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMealListBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(MealViewModel.class);
        viewModel.getMealsFromApi();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MealAdapter adapter = new MealAdapter(new MealComparator());
        setupRecyclerView(adapter);

        viewModel.getMeals().observe(getViewLifecycleOwner(), mealResponse -> adapter.submitList(mealResponse.meals));
    }

    private void setupRecyclerView(MealAdapter adapter){
        binding.foodRV.setAdapter(adapter);
        binding.foodRV.setLayoutManager(new LinearLayoutManager(requireContext()));
    }
}