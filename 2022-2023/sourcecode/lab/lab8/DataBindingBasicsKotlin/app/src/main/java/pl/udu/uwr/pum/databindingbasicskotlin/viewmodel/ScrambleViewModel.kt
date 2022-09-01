package pl.udu.uwr.pum.databindingbasicskotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.udu.uwr.pum.databindingbasicskotlin.data.MAX_NO_OF_WORDS
import pl.udu.uwr.pum.databindingbasicskotlin.data.SCORE_INCREASE
import pl.udu.uwr.pum.databindingbasicskotlin.data.allWordsList

class ScrambleViewModel : ViewModel() {
    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score

    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount

    private var _currentScrambledWord = MutableLiveData<String>()
    val currentScrambledWord: LiveData<String>
        get() = _currentScrambledWord

    private var usedWordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    fun nextWord(): Boolean {
        return if (currentWordCount.value!! < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        return if (playerWord.equals(currentWord, true)) {
            increaseScore()
            true
        } else false
    }

    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        usedWordsList.clear()
        getNextWord()
    }

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        while (String(tempWord) == currentWord) tempWord.shuffle()
        if (usedWordsList.contains(currentWord)) getNextWord() else {
            _currentScrambledWord.value = String(tempWord)
            _currentWordCount.value = currentWordCount.value?.inc()
            usedWordsList.add(currentWord)
        }
    }

    private fun increaseScore() {
        _score.value = _score.value?.plus(SCORE_INCREASE)
    }

    init {
        getNextWord()
    }
}