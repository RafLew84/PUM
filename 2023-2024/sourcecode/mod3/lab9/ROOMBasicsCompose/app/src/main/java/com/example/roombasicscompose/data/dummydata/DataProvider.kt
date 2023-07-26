package com.example.roombasicscompose.data.dummydata

import com.example.roombasicscompose.data.User

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

    val users = (0..40).map { User(0,firstNames.random(), lastNames.random()) }
    val user: User
        get() = User(0,firstNames.random(), lastNames.random())
}