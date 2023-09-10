package com.example.a42_parcelableserializablebasics_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.a42_parcelableserializablebasics_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_KEY = "parcel_example";
    public static String EXTRA_SERIALIZABLE = "serializable_example";

    private Properties properties;
    private SerializableProperties serializableProperties;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        properties = new Properties(1, 2, "String");
        serializableProperties = new SerializableProperties(11, 12, "Serializable");

        binding.sendButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(EXTRA_KEY, properties);
            intent.putExtra(EXTRA_SERIALIZABLE, serializableProperties);
            startActivity(intent);
        });
    }
}