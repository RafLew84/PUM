package pl.udu.uwr.pum.notyjava;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import pl.udu.uwr.pum.notyjava.data.DataProvider;
import pl.udu.uwr.pum.notyjava.widget.NotyWidgetProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            DataProvider.dummyData.add("Main Activity");
        });
    }
}