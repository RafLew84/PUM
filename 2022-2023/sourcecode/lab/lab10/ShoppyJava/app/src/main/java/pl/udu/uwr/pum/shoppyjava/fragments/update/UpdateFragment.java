package pl.udu.uwr.pum.shoppyjava.fragments.update;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.udu.uwr.pum.shoppyjava.R;
import pl.udu.uwr.pum.shoppyjava.databinding.FragmentListBinding;
import pl.udu.uwr.pum.shoppyjava.databinding.FragmentUpdateBinding;
import pl.udu.uwr.pum.shoppyjava.fragments.add.AddFragmentDirections;
import pl.udu.uwr.pum.shoppyjava.model.Item;
import pl.udu.uwr.pum.shoppyjava.viewmodel.ItemViewModel;

public class UpdateFragment extends Fragment {

    private FragmentUpdateBinding binding;

    private ItemViewModel itemViewModel;

    private int itemId = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        itemId = requireArguments().getInt("id");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUpdateBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemViewModel.getItem(itemId).observe(getViewLifecycleOwner(), this::displayItem);

        binding.updateButton.setOnClickListener(v -> updateItem(view));
    }

    private void updateItem(View view) {
        String name = binding.nameEditText.getText().toString();
        String quantity = binding.quantityEditText.getText().toString();

        if (TextUtils.isEmpty(name) && TextUtils.isEmpty(quantity)){
            binding.nameEditText.setError("Podaj nazwę");
            binding.quantityEditText.setError("Podaj ilość");
        } else {
            Item item = new Item(itemId, name, Integer.parseInt(quantity));
            itemViewModel.update(item);
            Navigation.findNavController(view).navigate(UpdateFragmentDirections.actionUpdateFragmentToListFragment());
        }
    }

    private void displayItem(Item item) {
        binding.nameEditText.setText(item.getName());
        binding.quantityEditText.setText(String.valueOf(item.getQuantity()));
    }
}