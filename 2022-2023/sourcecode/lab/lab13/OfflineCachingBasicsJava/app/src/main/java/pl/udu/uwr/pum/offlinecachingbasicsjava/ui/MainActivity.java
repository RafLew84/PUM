package pl.udu.uwr.pum.offlinecachingbasicsjava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import dagger.hilt.android.AndroidEntryPoint;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.adapter.UserAdapter;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.adapter.UserComparator;
import pl.udu.uwr.pum.offlinecachingbasicsjava.databinding.ActivityMainBinding;
import pl.udu.uwr.pum.offlinecachingbasicsjava.util.Resource;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        UserAdapter adapter = new UserAdapter(new UserComparator());
        setupRecyclerView(adapter);

        viewModel.getUsers().observe(this, result -> {
            adapter.submitList(result.data);
        });
    }

    private void setupRecyclerView(UserAdapter adapter){
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}