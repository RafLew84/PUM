package com.example.collectandconvertbasicscompose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.collectandconvertbasicscompose.ui.screens.MainScreen
import com.example.collectandconvertbasicscompose.ui.screens.Screens
import com.example.collectandconvertbasicscompose.ui.screens.SecondScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        composable(route = Screens.MainScreen.route){
            MainScreen{navController.navigate(Screens.SecondScreen.route)}
        }

        composable(route = Screens.SecondScreen.route){
            SecondScreen()
        }
    }
}