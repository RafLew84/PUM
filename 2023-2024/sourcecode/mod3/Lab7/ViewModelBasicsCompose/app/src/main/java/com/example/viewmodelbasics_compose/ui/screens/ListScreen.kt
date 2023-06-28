package com.example.viewmodelbasics_compose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(){

    var word by remember { mutableStateOf("a") }

    Column(modifier = Modifier.padding(2.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                modifier = Modifier.padding(start = 4.dp),
                value = word,
                onValueChange = {word = it},
                label = {Text("New Word")}
            )

            Button(
                modifier = Modifier.weight(1f).padding(start = 2.dp, end = 4.dp),
                shape = RoundedCornerShape(8.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "ADD")
            }
        }

        LazyColumn(modifier = Modifier.weight(1f)){
            items(50){
                Text(
                    text = word,
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                )
            }
        }

        Button(
            modifier = Modifier.fillMaxWidth().padding(start = 2.dp, end = 4.dp),
            shape = RoundedCornerShape(8.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "CLEAR")
        }

        Button(
            modifier = Modifier.fillMaxWidth().padding(start = 2.dp, end = 4.dp),
            shape = RoundedCornerShape(8.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "RESET")
        }

    }
}