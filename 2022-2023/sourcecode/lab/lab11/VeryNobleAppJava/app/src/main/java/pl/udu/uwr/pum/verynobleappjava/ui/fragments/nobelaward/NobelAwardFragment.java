package pl.udu.uwr.pum.verynobleappjava.ui.fragments.nobelaward;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.udu.uwr.pum.verynobleappjava.R;
import pl.udu.uwr.pum.verynobleappjava.adapters.nobelprize.NobelPrizeAdapter;
import pl.udu.uwr.pum.verynobleappjava.adapters.nobelprize.NobelPrizeComparator;
import pl.udu.uwr.pum.verynobleappjava.adapters.nobelprizelaureates.LaureateAdapter;
import pl.udu.uwr.pum.verynobleappjava.adapters.nobelprizelaureates.LaureateComparator;
import pl.udu.uwr.pum.verynobleappjava.data.NobelAwardsResponse;
import pl.udu.uwr.pum.verynobleappjava.databinding.FragmentNobelAwardBinding;
import pl.udu.uwr.pum.verynobleappjava.databinding.FragmentNobleAwardsFragmentBinding;
import pl.udu.uwr.pum.verynobleappjava.ui.fragments.nobelawards.NobelAwardsViewModel;
import pl.udu.uwr.pum.verynobleappjava.util.Constants;

public class NobelAwardFragment extends Fragment {

    private FragmentNobelAwardBinding binding;

    private String category;
    private String awardYear;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNobelAwardBinding.inflate(inflater, container, false);
        category = requireArguments().getString("category");
        awardYear = requireArguments().getString("awardYear");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NobelAwardViewModel viewModel = new ViewModelProvider(this).get(NobelAwardViewModel.class);

        viewModel.getNobelPrize(Integer.parseInt(awardYear), Constants.categories.get(Constants.CATEGORIES.valueOf(category.toUpperCase().replaceAll("\\s+",""))));

        LaureateAdapter adapter = new LaureateAdapter(new LaureateComparator());

        setupRecyclerView(adapter);

        viewModel.getNobelPrize().observe(getViewLifecycleOwner(), nobelAwardsResponse -> {
            NobelAwardsResponse.NobelPrizes item = nobelAwardsResponse.getNobelPrizes().stream().findFirst().orElse(null);
            if (item != null) {
                if (item.getCategoryFullName() != null && item.getCategoryFullName().getEn() != null)
                    binding.categoryFullNameTextView.setText(item.getCategoryFullName().getEn());
                binding.dateAwardTextView.setText(item.getDateAwarded());
                adapter.submitList(item.getLaureates());
            }
        });

    }

    private void setupRecyclerView(LaureateAdapter adapter){
        binding.nobelAwardRV.setAdapter(adapter);
        binding.nobelAwardRV.setLayoutManager(new LinearLayoutManager(requireContext()));
    }
}