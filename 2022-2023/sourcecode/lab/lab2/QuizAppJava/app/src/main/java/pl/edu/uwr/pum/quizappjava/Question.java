package pl.edu.uwr.pum.quizappjava;

public class Question {
    private final String question;
    private final int imageSource;
    private final String answerOne;
    private final String answerTwo;
    private final String answerThree;
    private final int correctAnswer;

    public Question(String question,
                    int imageSource,
                    String answerOne,
                    String answerTwo,
                    String answerThree,
                    int correctAnswer) {
        this.question = question;
        this.imageSource = imageSource;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public int getImageSource() {
        return imageSource;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
