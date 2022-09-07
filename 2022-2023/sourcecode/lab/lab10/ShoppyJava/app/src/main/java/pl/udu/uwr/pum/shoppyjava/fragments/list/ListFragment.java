package pl.udu.uwr.pum.shoppyjava.fragments.list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        swipeToDelete(adapter);

        binding.clearDataFAB.setOnClickListener(v -> deleteAll());

        setupSearchView(adapter);
    }

    private void setupSearchView(ItemAdapter adapter) {
        binding.searchSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query != null) search(query, adapter);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null) search(newText, adapter);
                return true;
            }
        });
    }

    private void search(String query, ItemAdapter adapter){
        String searchQuery = "%" + query + "%";

        itemViewModel.search(searchQuery).observe(getViewLifecycleOwner(), adapter::submitList);
    }

    private void deleteAll() {
        itemViewModel.deleteAll();
    }

    private void swipeToDelete(ItemAdapter adapter) {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                itemViewModel.delete(adapter.getItemAt(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(binding.listRecyclerView);
    }
}