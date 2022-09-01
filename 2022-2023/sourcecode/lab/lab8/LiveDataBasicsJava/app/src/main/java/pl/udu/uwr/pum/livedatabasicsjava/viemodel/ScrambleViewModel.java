package pl.udu.uwr.pum.livedatabasicsjava.viemodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import pl.udu.uwr.pum.livedatabasicsjava.data.DataProvider;

public class ScrambleViewModel extends ViewModel {
    private final MutableLiveData<Integer> currentWordCount = new MutableLiveData<>(0);
    private final MutableLiveData<Integer> score = new MutableLiveData<>(0);
    private String currentWord;
    private final ArrayList<String> usedWordsList = new ArrayList<>();
    private final MutableLiveData<String> currentScrambledWord = new MutableLiveData<>();

    public ScrambleViewModel () {
        super();
        getNextWord();
    }

    public boolean nextWord() {
            if (currentWordCount.getValue() != null &&
                    currentWordCount.getValue() < DataProvider.MAX_NO_OF_WORDS) {
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
        score.setValue(0);
        currentWordCount.setValue(0);
        usedWordsList.clear();
        getNextWord();
    }

    private void getNextWord() {
        Random rand = new Random();
        currentWord = DataProvider.allWordsList.get(rand.nextInt(DataProvider.allWordsList.size()));;
        char[] tempWord = currentWord.toCharArray();
        if (usedWordsList.contains(currentWord)) getNextWord();
        else {
            do{
                for (int i = tempWord.length - 1; i > 0; i--){
                    int j = (int) (Math.random() * (i + 1));

                    char temp = tempWord[i];
                    tempWord[i] = tempWord[j];
                    tempWord[j] = temp;
                }
            }while (String.valueOf(tempWord).equals(currentWord));
            currentScrambledWord.setValue(Arrays.toString(tempWord)
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "")
                    .replace(" ", "")
                    .trim());
            if (currentWordCount.getValue() != null)
                currentWordCount.setValue(currentWordCount.getValue() + 1);
            usedWordsList.add(currentWord);
        }
    }

    private void increaseScore() {
        if (score.getValue() != null)
            score.setValue(score.getValue() + DataProvider.SCORE_INCREASE);
    }

    public LiveData<Integer> getScore() {
        return score;
    }

    public LiveData<String> getCurrentScrambledWord() {
        return currentScrambledWord;
    }

    public LiveData<Integer> getCurrentWordCount() {
        return currentWordCount;
    }
}
