package pl.udu.uwr.pum.foodyjava.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.udu.uwr.pum.foodyjava.R;
import pl.udu.uwr.pum.foodyjava.adapters.MealComparator;
import pl.udu.uwr.pum.foodyjava.adapters.favorite.FavoriteAdapter;
import pl.udu.uwr.pum.foodyjava.adapters.meallist.MealAdapter;
import pl.udu.uwr.pum.foodyjava.databinding.FragmentFavoriteBinding;
import pl.udu.uwr.pum.foodyjava.databinding.FragmentMealDetailBinding;
import pl.udu.uwr.pum.foodyjava.ui.MealViewModel;


public class FavoriteFragment extends Fragment {

    private FragmentFavoriteBinding binding;
    private MealViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(MealViewModel.class);
        viewModel.getAllMeals();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FavoriteAdapter adapter = new FavoriteAdapter(new MealComparator());
        setupRecyclerView(adapter);

        viewModel.getFavorites().observe(getViewLifecycleOwner(), adapter::submitList);

        swipeToDelete(adapter);
    }

    private void setupRecyclerView(FavoriteAdapter adapter){
        binding.favoriteRV.setAdapter(adapter);
        binding.favoriteRV.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    private void swipeToDelete(FavoriteAdapter adapter) {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                viewModel.delete(adapter.getItemAt(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(binding.favoriteRV);
    }
}