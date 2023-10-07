package com.example.jetpackcomposemultiselectlistbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposemultiselectlistbasics.ui.theme.JetpackComposeMultiselectListBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeMultiselectListBasicsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MultiSelectList()
                }
            }
        }
    }
}

@Composable
fun MultiSelectList() {
    var names by remember {
        mutableStateOf(List(50) { ListItem(name = "$it", isSelected = false) })
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(names.size) {index ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        names = names.mapIndexed { currentIndex, item ->
                            if (index == currentIndex) item.copy(isSelected = !item.isSelected)
                            else item
                        }
                    }
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = names[index].name,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    modifier = (
                            if (names[index].isSelected) Modifier.background(Color.Cyan)
                            else Modifier.background(Color.Transparent)
                            ).fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeMultiselectListBasicsTheme {
        MultiSelectList()
    }
}