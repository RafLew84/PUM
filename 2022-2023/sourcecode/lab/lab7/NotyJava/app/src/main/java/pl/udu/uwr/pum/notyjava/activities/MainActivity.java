package pl.udu.uwr.pum.notyjava.activities;

import android.appwidget.AppWidgetManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import pl.udu.uwr.pum.notyjava.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}