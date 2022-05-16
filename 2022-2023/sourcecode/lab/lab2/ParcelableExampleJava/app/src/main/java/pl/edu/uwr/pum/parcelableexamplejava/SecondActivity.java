package pl.edu.uwr.pum.parcelableexamplejava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        Properties prop = intent.getParcelableExtra(MainActivity.EXTRA_KEY);

        String result = "";

        if(prop != null)
            result = prop.getA() + prop.getB() + " " + prop.getC();

        textView.setText(result);
    }
}