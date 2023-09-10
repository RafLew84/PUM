package com.example.jetpackcomposepaddingvaluesbasics

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposepaddingvaluesbasics.ui.theme.JetpackComposePaddingValuesBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePaddingValuesBasicsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PaddingValuesIssue()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaddingValuesIssue(){
    Scaffold (
        topBar = { TopAppBar(title = { Text("TopBar") }, colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Magenta), modifier = Modifier.fillMaxHeight(0.2f)
        ) },
        content = { paddingValues ->
            Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
                Text(text = "1", fontSize = 150.sp, modifier = Modifier.align(Alignment.BottomEnd))
                Text(text = "2", fontSize = 150.sp, modifier = Modifier.align(Alignment.BottomStart))
                Text(text = "3", fontSize = 150.sp, modifier = Modifier.align(Alignment.TopEnd))
                Text(text = "4", fontSize = 150.sp, modifier = Modifier.align(Alignment.TopStart))
            }
        },
        bottomBar = { BottomAppBar(containerColor = Color.Magenta) { Text(text = "BottomBar") }}
    )
}