package com.example.viewmodelbasicsjava.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.viewmodelbasicsjava.data.DataProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordViewModel extends ViewModel {
    private List<String> wordsList = new ArrayList<>();

    public List<String> getWordList() {
        return wordsList;
    }

    public WordViewModel() {
        reinitialize();
    }

    public void addWord(String word) {
        wordsList.add(word);
        Collections.sort(wordsList);
    }

    public void reinitialize() {
        wordsList.clear();
        wordsList.addAll(DataProvider.allWordsList);
        Collections.sort(wordsList);
    }

    public void clear() {
        wordsList.clear();
    }
}
