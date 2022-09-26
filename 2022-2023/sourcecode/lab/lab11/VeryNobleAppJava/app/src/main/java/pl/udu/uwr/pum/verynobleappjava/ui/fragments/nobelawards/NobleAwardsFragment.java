package pl.udu.uwr.pum.verynobleappjava.ui.fragments.nobelawards;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.List;

import pl.udu.uwr.pum.verynobleappjava.R;
import pl.udu.uwr.pum.verynobleappjava.adapters.nobelprize.NobelPrizeAdapter;
import pl.udu.uwr.pum.verynobleappjava.adapters.nobelprize.NobelPrizeComparator;
import pl.udu.uwr.pum.verynobleappjava.databinding.FragmentNobleAwardsFragmentBinding;
import pl.udu.uwr.pum.verynobleappjava.util.Constants;

public class NobleAwardsFragment extends Fragment {


    private FragmentNobleAwardsFragmentBinding binding;

    private NobelAwardsViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNobleAwardsFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(NobelAwardsViewModel.class);

        NobelPrizeAdapter adapter = new NobelPrizeAdapter(new NobelPrizeComparator());
        setupRecyclerView(adapter);

        viewModel.getNobelPrizes().observe(getViewLifecycleOwner(), nobelAwardsResponse -> {
            adapter.submitList(nobelAwardsResponse.getNobelPrizes());
        });

        setupSpinner();
    }

    private void setupRecyclerView(NobelPrizeAdapter adapter){
        binding.nobelPrizeRV.setAdapter(adapter);
        binding.nobelPrizeRV.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    private void setupSpinner(){
        binding.categorySpinner.setAdapter(
                new ArrayAdapter<>(requireContext(),
                        R.layout.spinner_nobel_award_layout,
                        (Constants.categories.values().toArray())));
        binding.categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewModel.getNobelPrizes(200, "desc", 1901, 2022,
                        (Constants.categories.values().toArray()[position].toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}