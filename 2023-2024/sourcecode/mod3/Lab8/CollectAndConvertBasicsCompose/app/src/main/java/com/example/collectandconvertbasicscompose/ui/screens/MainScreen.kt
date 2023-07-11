package com.example.collectandconvertbasicscompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.collectandconvertbasicscompose.viewmodel.CounterViewModel

@Composable
fun MainScreen(onSecondScreen: () -> Unit) {

    val viewModel: CounterViewModel = viewModel()
    val counter = viewModel.counter.collectAsStateWithLifecycle()

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(counter.value.toString(), fontSize = 36.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onSecondScreen) {
            Text("Go to Second Screen")
        }
    }
}