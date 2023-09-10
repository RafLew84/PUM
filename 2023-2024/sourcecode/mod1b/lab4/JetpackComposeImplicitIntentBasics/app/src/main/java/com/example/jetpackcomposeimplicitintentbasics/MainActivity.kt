package com.example.jetpackcomposeimplicitintentbasics

import android.content.Context
import android.content.Intent
import android.content.Intent.CATEGORY_BROWSABLE
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import com.example.jetpackcomposeimplicitintentbasics.ui.theme.JetpackComposeImplicitIntentBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeImplicitIntentBasicsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImplicitIntentButton()
                }
            }
        }
    }
}

@Composable
fun ImplicitIntentButton() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick = { openHomepage(context) },
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth(0.6f),
        ) {
            Text(text = "OPEN HOMEPAGE")
        }
    }
}

private fun openHomepage(context: Context){
    val url = "http://wfia.uni.wroc.pl/"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply{
        addCategory(CATEGORY_BROWSABLE)
    }

    context.startActivity(intent)
}