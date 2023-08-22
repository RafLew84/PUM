package com.example.retrofitbasicscompose.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.retrofitbasicscompose.api.RetrofitInstance
import com.example.retrofitbasicscompose.viewmodel.PostViewModel

@Composable
fun PostScreen(){
    val viewModel: PostViewModel = viewModel()

    val posts by viewModel.posts.collectAsStateWithLifecycle()

    Log.d("data", posts.toString())

    LazyColumn {
        items(posts) { post ->
            Column {
                Text(
                    text = "TITLE:\n" + post.title,
                    Modifier.padding(4.dp)
                )
                Text(
                    text = "CONTENT:\n" + post.content,
                    Modifier.padding(4.dp)
                )
                Text(
                    text = "USER ID:\n" + post.userId.toString(),
                    Modifier.padding(4.dp)
                )
                Spacer(modifier = Modifier.padding(12.dp))
            }
        }
    }
}