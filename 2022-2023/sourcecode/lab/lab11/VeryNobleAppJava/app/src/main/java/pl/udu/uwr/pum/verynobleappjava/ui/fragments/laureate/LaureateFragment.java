package pl.udu.uwr.pum.verynobleappjava.ui.fragments.laureate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import pl.udu.uwr.pum.verynobleappjava.adapters.laureatenobelprizes.NobelPrizeAdapter;
import pl.udu.uwr.pum.verynobleappjava.adapters.laureatenobelprizes.NobelPrizeComparator;
import pl.udu.uwr.pum.verynobleappjava.databinding.FragmentLaureateBinding;

public class LaureateFragment extends Fragment {

    private FragmentLaureateBinding binding;

    private String id;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLaureateBinding.inflate(inflater, container, false);
        id = requireArguments().getString("id");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LaureateViewModel viewModel = new ViewModelProvider(this).get(LaureateViewModel.class);

        viewModel.getLaureate(id);

        NobelPrizeAdapter adapter = new NobelPrizeAdapter(new NobelPrizeComparator());

        setupRecyclerView(adapter);

        viewModel.getLaureate().observe(getViewLifecycleOwner(), laureateResponse -> {
            binding.fullNameTextView.setText(laureateResponse.get(0).fullName.en);
            binding.birthDateTextView.setText(laureateResponse.get(0).birth.date);
            binding.birthCityTextView.setText(laureateResponse.get(0).birth.place.city.en);
            binding.birthCountryTextView.setText(laureateResponse.get(0).birth.place.country.en);
            if (laureateResponse.get(0).death != null) {
                binding.deathDateTextView.setText(laureateResponse.get(0).death.date);
                binding.deathCityTextView.setText(laureateResponse.get(0).death.place.city.en);
                binding.deathCountryTextView.setText(laureateResponse.get(0).death.place.country.en);
            }
            else {
                binding.deathDateTextView.setText("");
                binding.deathCityTextView.setText("");
                binding.deathCountryTextView.setText("");
            }
            adapter.submitList(laureateResponse.get(0).nobelPrizes);

            binding.wikiButton.setOnClickListener(v -> {
                NavDirections action = LaureateFragmentDirections
                        .actionLaureateFragmentToWikiLaureateFragmentFragment(
                                laureateResponse.get(0).wikipedia.english
                        );
                Navigation.findNavController(view).navigate(action);
            });
        });
    }

    private void setupRecyclerView(NobelPrizeAdapter adapter){
        binding.laureateRV.setAdapter(adapter);
        binding.laureateRV.setLayoutManager(new LinearLayoutManager(requireContext()));
    }
}