package pl.udu.uwr.pum.verynobleappjava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import pl.udu.uwr.pum.verynobleappjava.R;
import pl.udu.uwr.pum.verynobleappjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private NavController navController;
    private AppBarConfiguration appBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment);

        if (navHostFragment != null) {
            navController =
                    NavHostFragment.findNavController(navHostFragment);
        }

        appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph())
                        .build();

        NavigationUI.setupActionBarWithNavController(
                this,
                navController,
                appBarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI
                .navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}