package pl.edu.uwr.pum.quizappjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public final class Questions {
    private Questions(){}

    public static ArrayList<Question> getQuestions(){
        Random random = new Random();
        int capacity = 10;
        ArrayList<Question> questions = new ArrayList<>(capacity);
        for(int i = 0; i < capacity; i++){
            questions.add(
                    new Question(
                            "Question " + i,
                            R.drawable.ic_flag,
                            "Answer 1",
                            "Answer 2",
                            "Answer 3",
                            random.nextInt(3) + 1
                    )
            );
        }
        return questions;
    }
}
