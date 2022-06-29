package pl.edu.uwr.pum.quickyogaappkotlin

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList


class ExerciseActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var timer: CountDownTimer

    private var progressBarValue = 0
    private val waitTimerDuration = 5000L
    private val timerInterval: Long = 1000
    private val waitProgressInterval = 5
    private val yogaTimerDuration = 7000L
    private val yogaProgressInterval = 7

    private var isYoga = false

    private val yogaPosesList: ArrayList<YogaPose> = YogaPoses.yogaPoses
    private var exercisePosition = 0

    private val textToSpeech by lazy { TextToSpeech(this, this) }
    private lateinit var mediaPlayer: MediaPlayer

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerView) }
    private val adapter: YogaAdapter by lazy { YogaAdapter(this, yogaPosesList) }

    private val progressBar by lazy { findViewById<ProgressBar>(R.id.progress_bar)}
    private val textViewCounter by lazy { findViewById<TextView>(R.id.text_view_counter) }
    private val imageView by lazy { findViewById<ImageView>(R.id.yoga_image) }
    private val textViewExerciseName by lazy { findViewById<TextView>(R.id.text_view_exercise_title) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressed() }
        setupProgressBar()

        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        timer.cancel()
        progressBarValue = 0

        exercisePosition = 0; // resetowanie pozycji

        textToSpeech.stop();
        textToSpeech.shutdown();

        mediaPlayer.stop()

        super.onDestroy()
    }

    private fun setupProgressBar() {
        val timerDuration: Long
        val progressInterval: Int
        if (isYoga) {
            // ćwiczenie
            timerDuration = yogaTimerDuration
            progressInterval = yogaProgressInterval
            speakPoseName(yogaPosesList[exercisePosition].name)
            progressBar.max = yogaProgressInterval
            textViewExerciseName.text = yogaPosesList[exercisePosition].name // tytuł
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(yogaPosesList[exercisePosition].image) // grafika
            yogaPosesList[exercisePosition].isSelected = true
            adapter.notifyItemChanged(exercisePosition)
        } else {
            // oczekiwanie
            timerDuration = waitTimerDuration
            progressInterval = waitProgressInterval
            try {
                mediaPlayer = MediaPlayer.create(this, R.raw.dingding)
                mediaPlayer.isLooping = false
                mediaPlayer.start()
            } catch (e: Exception){
                e.printStackTrace()
            }
            progressBar.max = progressInterval
            imageView.visibility = View.INVISIBLE
            textViewExerciseName.text = getString(R.string.wait_text)
        }
        timer = object: CountDownTimer(timerDuration, timerInterval) {
            override fun onTick(l: Long) {
                progressBarValue++
                progressBar.progress = progressInterval - progressBarValue
                textViewCounter.text = (progressInterval - progressBarValue).toString()}
            override fun onFinish() {
                if (exercisePosition < yogaPosesList.size)
                    setupProgressBar()
                else
                    Toast.makeText(this@ExerciseActivity, "COMPLETE", Toast.LENGTH_SHORT).show();
                timer.cancel()
                progressBarValue = 0

                if (isYoga) {
                    yogaPosesList[exercisePosition].isSelected = false
                    yogaPosesList[exercisePosition].isCompleted = true
                    adapter.notifyItemChanged(exercisePosition);
                    exercisePosition++
                }

                isYoga = !isYoga
                setupProgressBar()
            }
        }.start()
        progressBar.progress = progressBarValue
    }

    override fun onInit(p0: Int) {
        if (p0 == TextToSpeech.SUCCESS)
            textToSpeech.language = Locale.ENGLISH
    }

    private fun speakPoseName(text: String) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }
}