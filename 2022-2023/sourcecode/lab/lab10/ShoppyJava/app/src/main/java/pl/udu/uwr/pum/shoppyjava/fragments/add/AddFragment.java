package pl.udu.uwr.pum.shoppyjava.fragments.add;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import pl.udu.uwr.pum.shoppyjava.model.Item;
import pl.udu.uwr.pum.shoppyjava.viewmodel.ItemViewModel;
import pl.udu.uwr.pum.shoppyjava.databinding.FragmentAddBinding;

public class AddFragment extends Fragment {

    private FragmentAddBinding binding;

    private ItemViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(ItemViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.saveButton.setOnClickListener(v -> {
            insertToDatabase(view);
        });
    }

    private void insertToDatabase(View view) {
        String name = binding.nameEditText.getText().toString();
        String quantity = binding.quantityEditText.getText().toString();

        if (TextUtils.isEmpty(name) && TextUtils.isEmpty(quantity)){
            binding.nameEditText.setError("Podaj nazwę");
            binding.quantityEditText.setError("Podaj ilość");
        } else {
            Item item = new Item(0, name, Integer.parseInt(quantity));
            viewModel.insert(item);
            Navigation.findNavController(view).navigate(AddFragmentDirections.actionAddFragmentToListFragment());
        }
    }
}