package pl.edu.uwr.pum.quizappkotlin

import kotlin.random.Random
import kotlin.random.nextInt

object Questions {
    val questions: List<Question>
        get() = (0 until 10).map { Question(
            "Question $it",
            R.drawable.ic_flag,
            "Answer 1",
            "Answer 2",
            "Answer 3",
            Random.nextInt(IntRange(1,3))
        ) }
}