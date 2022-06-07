package pl.edu.uwr.pum.quizappkotlin

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    private var currentPosition = 1
    private val questions: List<Question> = Questions.questions
    private var selectedAnswerPosition = 0

    private val answerOne: TextView by lazy { findViewById(R.id.text_view_answer_one) }
    private val answerTwo: TextView by lazy { findViewById(R.id.text_view_answer_two) }
    private val answerThree: TextView by lazy { findViewById(R.id.text_view_answer_three) }
    private val questionText: TextView by lazy { findViewById(R.id.text_view_question) }
    private val progressText: TextView by lazy { findViewById(R.id.text_view_progress) }
    private val submitButton: Button by lazy { findViewById(R.id.button_next) }
    private val progressBar: ProgressBar by lazy { findViewById(R.id.progress_bar) }
    private val imageView: ImageView by lazy { findViewById(R.id.image_view_question) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setQuestion()

        answerOne.setOnClickListener { setSelectedView(answerOne, 1) }
        answerTwo.setOnClickListener { setSelectedView(answerTwo, 2) }
        answerThree.setOnClickListener { setSelectedView(answerThree, 3) }
        submitButton.setOnClickListener {
            if (selectedAnswerPosition == 0) {
                currentPosition++
                if (currentPosition <= questions.size)
                    setQuestion()
                else
                    Toast.makeText(
                        this, "Quiz completed",
                        Toast.LENGTH_SHORT
                    ).show()
            } else {
                val question = questions[currentPosition - 1]
                if (question.correctAnswer != selectedAnswerPosition)
                    setAnswerView(selectedAnswerPosition, R.drawable.incorrect_answer_shape)
                setAnswerView(question.correctAnswer,R.drawable.correct_answer_shape)

                if (currentPosition == questions.size)
                    submitButton.text = "FINISH"
                else {
                    changeClickableAnswers(false)
                    submitButton.text = "NEXT QUESTION"
                }
            }
            selectedAnswerPosition = 0
        }
    }

    private fun setQuestion() {
        val question = questions[currentPosition - 1]
        setDefaultView()
        progressBar.progress = currentPosition
        "$currentPosition / ${progressBar.max}".also { progressText.text = it }
        questionText.text = question.question
        answerOne.text = question.answerOne
        answerTwo.text = question.answerTwo
        answerThree.text = question.answerThree
        imageView.setImageResource(question.imageSource);
        submitButton.text = "SUBMIT"
        changeClickableAnswers(true)
    }

    private fun setDefaultView() {
        val answers: List<TextView> = listOf(answerOne, answerTwo, answerThree)
        answers.forEach {
            it.setTextColor(Color.parseColor("#000000"))
            it.typeface = Typeface.DEFAULT
            it.background = ContextCompat.getDrawable(this, R.drawable.default_answer_shape)
        }
    }

    private fun setSelectedView(textView: TextView, selectedAnswer: Int) {
        setDefaultView()
        selectedAnswerPosition = selectedAnswer
        textView.apply {
            setTypeface(textView.typeface, Typeface.BOLD)
            background =
                ContextCompat.getDrawable(this@MainActivity, R.drawable.selected_answer_shape)
        }
    }

    private fun setAnswerView(answer: Int, drawableItem: Int) {
        when (answer) {
            1 -> answerOne.background = ContextCompat.getDrawable(this, drawableItem)
            2 -> answerTwo.background = ContextCompat.getDrawable(this, drawableItem)
            3 -> answerThree.background = ContextCompat.getDrawable(this, drawableItem)
        }
    }

    private fun changeClickableAnswers(isAnswered: Boolean) {
        answerOne.isClickable = isAnswered
        answerTwo.isClickable = isAnswered
        answerThree.isClickable = isAnswered
    }
}