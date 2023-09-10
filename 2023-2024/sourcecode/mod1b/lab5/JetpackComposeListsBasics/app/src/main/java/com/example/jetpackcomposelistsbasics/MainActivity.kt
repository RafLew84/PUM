package com.example.jetpackcomposelistsbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposelistsbasics.ui.theme.JetpackComposeListsBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeListsBasicsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListOfWords(generateWordList())
                }
            }
        }
    }
}

@Composable
fun ListOfWords(words: MutableList<String>){
    LazyColumn{
        items(words.size){
            var word by remember {
                mutableStateOf(words[it])
            }
            Text(
                text = word,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
                    .clickable {
                        word += "Clicked!!!"
                        words[it] = word
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    JetpackComposeListsBasicsTheme {
        ListOfWords(generateWordList())
    }
}

private fun generateWordList(): MutableList<String> {
    return (1..50).map { "word $it" }.toMutableList()
}