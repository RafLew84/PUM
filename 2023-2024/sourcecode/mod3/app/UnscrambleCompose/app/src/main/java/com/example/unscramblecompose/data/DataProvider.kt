package com.example.unscramblecompose.data

const val MAX_NO_OF_WORDS = 10
const val SCORE_INCREASE = 20
object DataProvider {
    private val _words = listOf(
        "kot", "pies", "drab", "kawa", "samolot", "wino", "stół", "gracz", "woda", "dom",
        "karma", "tanie", "bilet", "muzyk", "rybak", "wąż", "śmieć", "słoń", "chleb", "motyw",
        "las", "żaba", "papuga", "talerz", "stacja", "grupa", "słoik", "butelka", "kurczak",
        "róża", "okno", "drzewo", "lampa", "sklep", "kasa", "broda", "łóżko", "papier", "szafa",
        "rękaw", "dzwon", "kotek"
    )

    val words: List<String>
        get() = _words.shuffled().take(MAX_NO_OF_WORDS)

}