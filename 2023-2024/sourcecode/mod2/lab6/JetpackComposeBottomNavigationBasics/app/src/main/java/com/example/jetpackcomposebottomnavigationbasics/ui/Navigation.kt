package com.example.jetpackcomposebottomnavigationbasics.ui

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposebottomnavigationbasics.ui.screens.BottomBar
import com.example.jetpackcomposebottomnavigationbasics.ui.screens.FirstScreen
import com.example.jetpackcomposebottomnavigationbasics.ui.screens.HomeScreen
import com.example.jetpackcomposebottomnavigationbasics.ui.screens.Screens
import com.example.jetpackcomposebottomnavigationbasics.ui.screens.SecondScreen
import com.example.jetpackcomposebottomnavigationbasics.ui.screens.SettingsScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomMenu(navController = navController)},
        topBar = {ActionBarMenu(navController = navController)},
        content = { BottomNavGraph(navController = navController) }
    )
}

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {
        composable(route = Screens.HomeScreen.route){ HomeScreen() }
        composable(route = Screens.FirstScreen.route){ FirstScreen() }
        composable(route = Screens.SecondScreen.route){ SecondScreen() }
        composable(route = Screens.SettingsScreen.route){ SettingsScreen()}
    }
}

@Composable
fun BottomMenu(navController: NavHostController){
    val screens = listOf(
        BottomBar.Home, BottomBar.First, BottomBar.Second
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar{
        screens.forEach{screen ->
            NavigationBarItem(
                label = { Text(text = screen.title)},
                icon = {Icon(imageVector = screen.icon, contentDescription = "icon")},
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {navController.navigate(screen.route)}
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActionBarMenu(navController: NavHostController){

    var displayMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = {Text("Navigation App", color = Color.Black) },
        actions = {
            IconButton(onClick = { displayMenu = !displayMenu }) {
                Icon(Icons.Default.MoreVert, "")
            }
            DropdownMenu(
                expanded = displayMenu,
                onDismissRequest = { displayMenu = false }
            ){
                DropdownMenuItem(text = { Text(text = "Settings") }, onClick = { navController.navigate(Screens.SettingsScreen.route) })
            }
        }
    )
}



