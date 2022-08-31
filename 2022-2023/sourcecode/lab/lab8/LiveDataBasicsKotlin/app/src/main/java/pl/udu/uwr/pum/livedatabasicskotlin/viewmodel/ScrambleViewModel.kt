package pl.udu.uwr.pum.livedatabasicskotlin.viewmodel

import androidx.lifecycle.ViewModel
import pl.udu.uwr.pum.livedatabasicskotlin.data.MAX_NO_OF_WORDS
import pl.udu.uwr.pum.livedatabasicskotlin.data.SCORE_INCREASE
import pl.udu.uwr.pum.livedatabasicskotlin.data.allWordsList

class ScrambleViewModel : ViewModel() {
    private var currentWordCount = 0

    private lateinit var _currentScrambledWord: String
    val currentScrambledWord: String
        get() = _currentScrambledWord

    private var usedWordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    private var _score = 0
    val score: Int
        get() = _score

    fun nextWord(): Boolean {
        return if (currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }

    fun reinitializeData() {
        _score = 0
        currentWordCount = 0
        usedWordsList.clear()
        getNextWord()
    }

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        while (String(tempWord) == currentWord) tempWord.shuffle()
        if (usedWordsList.contains(currentWord)) getNextWord() else {
            _currentScrambledWord = String(tempWord)
            ++currentWordCount
            usedWordsList.add(currentWord)
        }
    }

    private fun increaseScore() {
        _score += SCORE_INCREASE
    }

    init {
        getNextWord()
    }
}