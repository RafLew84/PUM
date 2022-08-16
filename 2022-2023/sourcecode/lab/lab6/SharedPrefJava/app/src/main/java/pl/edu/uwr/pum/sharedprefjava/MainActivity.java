package pl.edu.uwr.pum.sharedprefjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import pl.edu.uwr.pum.sharedprefjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.countUpButton.setOnClickListener(v -> {
            counter++;
            binding.counter1TextView.setText(String.valueOf(counter));
        });

        binding.countDownButton.setOnClickListener(v -> {
            counter--;
            binding.counter1TextView.setText(String.valueOf(counter));
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPref = getSharedPreferences("fileName", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("counter", Integer.parseInt(binding.counter1TextView.getText().toString()));
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("fileName", MODE_PRIVATE);
        binding.counter1TextView.setText(String.valueOf(preferences.getInt("counter", 0)));
    }
}