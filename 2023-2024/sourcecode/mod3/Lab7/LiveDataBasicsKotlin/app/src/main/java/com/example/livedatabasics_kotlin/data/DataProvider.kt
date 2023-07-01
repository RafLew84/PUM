package com.example.livedatabasics_kotlin.data

import com.example.livedatabasics_kotlin.model.User

object DataProvider {

    private val firstNames = listOf(
        "Adam", "Ewa", "Jan", "Anna", "Piotr", "Maria", "Tomasz", "Małgorzata", "Krzysztof", "Alicja",
        "Andrzej", "Joanna", "Michał", "Barbara", "Kamil", "Magdalena", "Robert", "Monika", "Mateusz", "Natalia"
    )

    private val lastNames = listOf(
        "Nowak", "Kowalski", "Wiśniewski", "Wójcik", "Kowalczyk", "Kamiński", "Lewandowski", "Zieliński", "Szymański",
        "Woźniak", "Dąbrowski", "Kozłowski", "Jankowski", "Mazur", "Kwiatkowski", "Krawczyk", "Piotrowski", "Grabowski",
        "Nowakowski", "Pawłowski"
    )

    val users = (0..50).map { User(firstNames.random(), lastNames.random()) }
}