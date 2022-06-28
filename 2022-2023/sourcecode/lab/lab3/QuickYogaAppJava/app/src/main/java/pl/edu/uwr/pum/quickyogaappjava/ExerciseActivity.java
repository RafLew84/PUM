package pl.edu.uwr.pum.quickyogaappjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class ExerciseActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private ArrayList<YogaPose> yogaPosesList;
    private int exercisePosition = 0;

    private CountDownTimer timer;
    private int progressBarValue = 0;
    private boolean isYoga = false;
    private long waitTimerDuration = 5000L;
    private long yogaTimerDuration = 7000L;
    private long timerInterval = 1000;
    private int waitProgressInterval = 5;
    private int yogaProgressInterval = 7;

    private ProgressBar progressBar;
    private TextView textViewCounter;
    private ImageView imageView;
    private TextView textViewExerciseName;

    private TextToSpeech textToSpeech;
    private MediaPlayer player;

    private YogaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        progressBar = findViewById(R.id.progress_bar);
        textViewCounter = findViewById(R.id.text_view_counter);
        imageView = findViewById(R.id.yoga_image);
        textViewExerciseName = findViewById(R.id.text_view_exercise_title);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());
        textToSpeech = new TextToSpeech(this, this);
        yogaPosesList = YogaPoses.getYogaPoses();
        setupProgressBar();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.HORIZONTAL,
                        false));
        adapter = new YogaAdapter(this, yogaPosesList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        if (timer != null) {
            timer.cancel();
            progressBarValue = 0;
        }

        if (player != null)
            player.stop();

        exercisePosition = 0;

        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }

        super.onDestroy();
    }

    private void setupProgressBar(){
        long timerDuration;
        int progressInterval;
        if (isYoga){
            timerDuration = yogaTimerDuration;
            progressInterval = yogaProgressInterval;
            speakPoseName(yogaPosesList.get(exercisePosition).getName());
            progressBar.setMax(yogaProgressInterval);
            textViewExerciseName.setText(yogaPosesList.get(exercisePosition).getName());
            imageView.setVisibility(View.VISIBLE);
            yogaPosesList.get(exercisePosition).setSelected(true);
            adapter.notifyItemChanged(exercisePosition);
            imageView.setImageResource(yogaPosesList.get(exercisePosition).getImage());
        }else{
            timerDuration = waitTimerDuration;
            progressInterval = waitProgressInterval;
            if (exercisePosition > 0) {
                try {
                    player = MediaPlayer.create(this, R.raw.dingding);
                    player.setLooping(false);
                    player.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            progressBar.setMax(progressInterval);
            imageView.setVisibility(View.INVISIBLE);
            textViewExerciseName.setText(getString(R.string.wait_text));
        }
        progressBar.setProgress(progressBarValue);
        timer = new CountDownTimer(timerDuration, timerInterval) {
            @Override
            public void onTick(long l) {
                progressBarValue++;
                progressBar.setProgress(progressInterval - progressBarValue);
                textViewCounter.setText(String.valueOf(progressInterval - progressBarValue));
            }

            @Override
            public void onFinish() {
                Toast.makeText(ExerciseActivity.this, "YOGA TIME", Toast.LENGTH_SHORT).show();
                if (timer != null) {
                    timer.cancel();
                    progressBarValue = 0;
                }

                if (isYoga){
                    yogaPosesList.get(exercisePosition).setSelected(false);
                    yogaPosesList.get(exercisePosition).setCompleted(true);
                    adapter.notifyItemChanged(exercisePosition);
                    exercisePosition++;
                }

                isYoga = !isYoga;

                if (exercisePosition < yogaPosesList.size())
                    setupProgressBar();
                else
                    Toast.makeText(ExerciseActivity.this, "COMPLETE", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS)
            textToSpeech.setLanguage(Locale.ENGLISH);
    }

    private void speakPoseName(String text){
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, "");
    }
}