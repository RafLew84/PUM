package com.example.jetpackcomposebottomnavigationbasics.ui.screens

sealed class Screens(val route: String) {
    object HomeScreen : Screens("home")
    object FirstScreen : Screens("first")
    object SecondScreen : Screens("second")
    object SettingsScreen : Screens("settings")
}