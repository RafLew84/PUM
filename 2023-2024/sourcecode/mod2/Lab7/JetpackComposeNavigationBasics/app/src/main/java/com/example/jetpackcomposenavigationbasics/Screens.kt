package com.example.jetpackcomposenavigationbasics

sealed class Screens(val route: String) {
    object MainScreen : Screens("main_screen")
    object SecondScreen : Screens("second_screen")
}