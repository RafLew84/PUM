package com.example.a42_parcelableserializablebasics_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.a42_parcelableserializablebasics_java.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Properties properties;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            properties = getIntent().getParcelableExtra(MainActivity.EXTRA_KEY, Properties.class);
        } else {
            properties = getIntent().getParcelableExtra(MainActivity.EXTRA_KEY);
        }

        SerializableProperties serializableProperties;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            serializableProperties = getIntent().getSerializableExtra(MainActivity.EXTRA_SERIALIZABLE, SerializableProperties.class);
        } else {
            serializableProperties = (SerializableProperties) getIntent().getSerializableExtra(MainActivity.EXTRA_SERIALIZABLE);
        }

        String result = "";

        if(properties != null && serializableProperties != null)
            result = properties.getA() + properties.getB() + " " + properties.getC() + "---" + serializableProperties.getA() + "\n" +
                    serializableProperties.getB() + " " + serializableProperties.getC();

        binding.textView.setText(result);
    }
}