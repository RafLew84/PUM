package pl.udu.uwr.pum.shoppyjava.fragments.list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.udu.uwr.pum.shoppyjava.databinding.FragmentListBinding;
import pl.udu.uwr.pum.shoppyjava.viewmodel.ItemViewModel;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;

    private ItemViewModel itemViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ItemAdapter adapter = new ItemAdapter(new ItemComparator());
        binding.listRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.listRecyclerView.setAdapter(adapter);

        itemViewModel.getAllData().observe(getViewLifecycleOwner(), adapter::submitList);

        binding.addItemFAB.setOnClickListener(v ->
                Navigation.findNavController(view)
                        .navigate(ListFragmentDirections.actionListFragmentToAddFragment()));
    }
}