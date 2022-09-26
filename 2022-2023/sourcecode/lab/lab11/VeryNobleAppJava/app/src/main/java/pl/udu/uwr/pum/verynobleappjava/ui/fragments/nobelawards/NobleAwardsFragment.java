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

import pl.udu.uwr.pum.verynobleappjava.adapters.nobelprize.NobelPrizeAdapter;
import pl.udu.uwr.pum.verynobleappjava.adapters.nobelprize.NobelPrizeComparator;
import pl.udu.uwr.pum.verynobleappjava.databinding.FragmentNobleAwardsFragmentBinding;

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
    }

    private void setupRecyclerView(NobelPrizeAdapter adapter){
        binding.nobelPrizeRV.setAdapter(adapter);
        binding.nobelPrizeRV.setLayoutManager(new LinearLayoutManager(requireContext()));
    }
}