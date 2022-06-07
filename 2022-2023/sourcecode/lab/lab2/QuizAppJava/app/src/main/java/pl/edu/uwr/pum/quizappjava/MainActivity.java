package pl.edu.uwr.pum.quizappjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int currentPosition = 1;
    private final ArrayList<Question> questions = Questions.getQuestions();
    private int selectedAnswerPosition = 0;

    private TextView answerOne, answerTwo, answerThree, questionText, progressText;
    private Button submitButton;
    private ProgressBar progressBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerOne = findViewById(R.id.text_view_answer_one);
        answerTwo = findViewById(R.id.text_view_answer_two);
        answerThree = findViewById(R.id.text_view_answer_three);
        questionText = findViewById(R.id.text_view_question);
        submitButton = findViewById(R.id.button_next);
        progressBar = findViewById(R.id.progress_bar);
        imageView = findViewById(R.id.image_view_question);
        progressText = findViewById(R.id.text_view_progress);

        answerOne.setOnClickListener(view -> {
            setSelectedView(answerOne, 1);
        });

        answerTwo.setOnClickListener(view -> {
            setSelectedView(answerTwo, 2);
        });

        answerThree.setOnClickListener(view -> {
            setSelectedView(answerThree, 3);
        });

        submitButton.setOnClickListener(view -> {
            if (selectedAnswerPosition == 0) {
                currentPosition++;
                if (currentPosition <= questions.size())
                    setQuestion();
                else
                    Toast.makeText(this, "Quiz completed",
                            Toast.LENGTH_SHORT).show();
            } else {
                Question question = questions.get(currentPosition - 1);
                if (question.getCorrectAnswer() != selectedAnswerPosition)
                    setAnswerView(selectedAnswerPosition, R.drawable.incorrect_answer_shape);
                setAnswerView(question.getCorrectAnswer(), R.drawable.correct_answer_shape);


                if (currentPosition == questions.size())
                    submitButton.setText("FINISH");
                else {
                    changeClickableAnswers(false);
                    submitButton.setText("NEXT QUESTION");
                }
            }

            selectedAnswerPosition = 0;
        });

        setQuestion();
    }

    private void setQuestion(){
        Question question = questions.get(currentPosition - 1);
        setDefaultView();
        progressBar.setProgress(currentPosition);
        progressText.setText(currentPosition + "/" + progressBar.getMax());
        questionText.setText(question.getQuestion());
        answerOne.setText(question.getAnswerOne());
        answerTwo.setText(question.getAnswerTwo());
        answerThree.setText(question.getAnswerThree());
        imageView.setImageResource(question.getImageSource());
        submitButton.setText("SUBMIT");
        changeClickableAnswers(true);
    }

    private void setDefaultView(){
        ArrayList<TextView> answers = new ArrayList<TextView>(){{
            add(answerOne);
            add(answerTwo);
            add(answerThree);
        }};

        for (TextView answer : answers){
            answer.setTextColor(Color.parseColor("#000000"));
            answer.setTypeface(Typeface.DEFAULT);
            answer.setBackground(ContextCompat.getDrawable(this, R.drawable.default_answer_shape));
        }
    }

    private void setAnswerView(int answer, int drawableItem){
        switch (answer){
            case 1:
                answerOne.setBackground(ContextCompat.getDrawable(this, drawableItem));
                break;
            case 2:
                answerTwo.setBackground(ContextCompat.getDrawable(this, drawableItem));
                break;
            case 3:
                answerThree.setBackground(ContextCompat.getDrawable(this, drawableItem));
                break; default: break;
        }
    }

    private void setSelectedView(TextView textView, int selectedAnswer){
        setDefaultView();
        selectedAnswerPosition = selectedAnswer;
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
        textView.setBackground(ContextCompat.getDrawable(this, R.drawable.selected_answer_shape));
    }

    private void changeClickableAnswers(boolean isAnswered){
        answerOne.setClickable(isAnswered);
        answerTwo.setClickable(isAnswered);
        answerThree.setClickable(isAnswered);
    }
}