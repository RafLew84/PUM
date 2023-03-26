package com.example.a31_explicitintentbasicsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a31_explicitintentbasicsjava.databinding.ActivityMainBinding;
import com.example.a31_explicitintentbasicsjava.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.a31_explicitintentbasicsjava.REPLY";
    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        binding.textView.setText(message);

        binding.returnButton.setOnClickListener(view -> returnMessage());
    }

    private void returnMessage() {
        String reply = binding.editTextSecond.getText().toString();
        Intent intent = new Intent();

        intent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, intent);
        finish();
    }
}