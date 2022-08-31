package pl.udu.uwr.pum.livedatabasicsjava.viemodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import pl.udu.uwr.pum.livedatabasicsjava.data.DataProvider;

public class ScrambleViewModel extends ViewModel {
    private int currentWordCount = 0;
    private int score = 0;
    private String currentWord;
    private final ArrayList<String> usedWordsList = new ArrayList<>();
    private String currentScrambledWord;

    public ScrambleViewModel () {
        super();
        getNextWord();
    }

    public boolean nextWord() {
        if (currentWordCount < DataProvider.MAX_NO_OF_WORDS) {
            getNextWord();
            return true;
        }
        return false;
    }

    public boolean isUserWordCorrect(String playerWord) {
        if (playerWord.equals(currentWord)) {
            increaseScore();
            return true;
        }
        return false;
    }

    public void reinitializeData() {
        score = 0;
        currentWordCount = 0;
        usedWordsList.clear();
        getNextWord();
    }

    private void getNextWord() {
        Random rand = new Random();
        currentWord = DataProvider.allWordsList.get(rand.nextInt(DataProvider.allWordsList.size()));;
        char[] tempWord = currentWord.toCharArray();
        while (String.valueOf(tempWord).equals(currentWord)){
            for (int i = tempWord.length - 1; i > 0; i--){
                int j = (int) (Math.random() * (i + 1));

                char temp = tempWord[i];
                tempWord[i] = tempWord[j];
                tempWord[j] = temp;
            }
        }
        if (usedWordsList.contains(currentWord)) getNextWord();
        else {
            currentScrambledWord = Arrays.toString(tempWord)
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "")
                    .replace(" ", "")
                    .trim();
            ++currentWordCount;
            usedWordsList.add(currentWord);
        }
    }

    private void increaseScore() {
        score += DataProvider.SCORE_INCREASE;
    }

    public int getScore() {
        return score;
    }

    public String getCurrentScrambledWord() {
        return currentScrambledWord;
    }
}
