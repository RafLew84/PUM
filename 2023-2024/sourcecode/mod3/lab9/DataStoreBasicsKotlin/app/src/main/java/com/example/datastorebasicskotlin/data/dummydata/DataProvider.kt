package com.example.datastorebasicskotlin.data.dummydata

object DataProvider {

    private val usernames = listOf(
        "CoolDude123",
        "SuperStar",
        "GamerGirl99",
        "TechMaster",
        "MusicLover",
        "FitnessFreak",
        "Traveler_21",
        "FoodieQueen",
        "NatureLover",
        "Fashionista",
        "Bookworm42",
        "MovieBuff",
        "AdventureSeeker",
        "PetLover_87",
        "SportsFanatic",
        "ArtisticSoul",
        "StarGazer",
        "YogaEnthusiast",
        "PhotographyPro",
        "DreamChaser",
        "BeachBum123",
        "CoffeeAddict",
        "GameChanger",
        "LaughOutLoud",
        "MindfulSoul",
        "HappyGoLucky",
        "TechGeek1",
        "FoodExplorer",
        "FitnessJunkie"
    )

    val username: String
        get() = usernames.random()
}