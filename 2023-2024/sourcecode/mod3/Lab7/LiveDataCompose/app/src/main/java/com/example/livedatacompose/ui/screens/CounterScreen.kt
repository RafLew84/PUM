package com.example.livedatacompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.livedatacompose.viewmodel.CounterViewModel

@Composable
fun CounterScreen() {

    val viewModel: CounterViewModel = viewModel()
    val counterState = viewModel.counter.observeAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(0.3f))
        Text(
            text = counterState.value.toString(),
            fontSize = 250.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f),
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                modifier = Modifier
                    .weight(.5f)
                    .padding(4.dp),
                shape = RoundedCornerShape(4.dp),
                onClick = {viewModel.increase()}
            ) {
                Text(text = "Increase")
            }
            Button(
                modifier = Modifier
                    .weight(.5f)
                    .padding(4.dp),
                shape = RoundedCornerShape(4.dp),
                onClick = {viewModel.decrease()}
            ) {
                Text(text = "Decrease")
            }
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = RectangleShape,
            onClick = {viewModel.clear()}
        ) {
            Text(text = "Reset")
        }
    }
}