package pl.edu.uwr.pum.quickyogaappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        findViewById(R.id.start_button_layout).setOnClickListener(view -> {
            Intent intent = new Intent(this, ExerciseActivity.class);
            startActivity(intent);
        });
    }
}