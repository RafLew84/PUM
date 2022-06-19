package pl.edu.uwr.pum.quickyogaappjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class ExerciseActivity extends AppCompatActivity {

    private CountDownTimer waitTimer;
    private int progressBarValue = 0;
    private long waitTimerDuration = 5000L;
    private long timerInterval = 1000;
    private int progressInterval = 5;

    private ProgressBar progressBar;
    private TextView textViewCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        progressBar = findViewById(R.id.progress_bar);
        textViewCounter = findViewById(R.id.text_view_counter);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> {
            onBackPressed();
        });
        setupProgressBar();
    }

    @Override
    protected void onDestroy() {
        if (waitTimer != null) {
            waitTimer.cancel();
            progressBarValue = 0;
        }
        super.onDestroy();
    }

    private void setupProgressBar(){
        progressBar.setProgress(progressBarValue);
        waitTimer = new CountDownTimer(waitTimerDuration, timerInterval) {
            @Override
            public void onTick(long l) {
                progressBarValue++;
                progressBar.setProgress(progressInterval - progressBarValue);
                textViewCounter.setText(String.valueOf(progressInterval - progressBarValue));
            }

            @Override
            public void onFinish() {
                Toast.makeText(ExerciseActivity.this, "YOGA TIME", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
}