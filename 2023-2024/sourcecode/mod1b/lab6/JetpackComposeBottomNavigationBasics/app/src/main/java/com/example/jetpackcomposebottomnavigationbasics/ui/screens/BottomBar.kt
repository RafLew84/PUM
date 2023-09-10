package com.example.jetpackcomposebottomnavigationbasics.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBar(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBar(Screens.HomeScreen.route, "Home", Icons.Default.Home)
    object First : BottomBar(Screens.FirstScreen.route, "First", Icons.Default.Info)
    object Second : BottomBar(Screens.SecondScreen.route, "Second", Icons.Default.Email)
}