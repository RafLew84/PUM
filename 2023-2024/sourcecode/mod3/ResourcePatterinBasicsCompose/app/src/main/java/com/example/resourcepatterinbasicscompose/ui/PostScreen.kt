package com.example.resourcepatterinbasicscompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.resourcepatterinbasicscompose.data.CommentResponseItem
import com.example.resourcepatterinbasicscompose.util.Resource
import com.example.resourcepatterinbasicscompose.viewmodel.CommentsViewModel

@Composable
fun CommentsScreen(){
    val viewModel: CommentsViewModel = viewModel()

    val response by viewModel.comments.collectAsStateWithLifecycle()


    when (response) {
        is Resource.Success -> { response.data?.let { ShowList(comments = it) } }
        is Resource.Error -> {  }
        is Resource.Loading -> {  }
    }
}

@Composable
private fun ShowList(comments: List<CommentResponseItem>) {
    LazyColumn {
        items(comments) { comment ->
            Column {
                Text(
                    text = "NAME:\n" + comment.name,
                    Modifier.padding(4.dp)
                )
                Text(
                    text = "CONTENT:\n" + comment.body,
                    Modifier.padding(4.dp)
                )
                Text(
                    text = "POST ID:\n" + comment.postId.toString(),
                    Modifier.padding(4.dp)
                )
                Spacer(modifier = Modifier.padding(12.dp))
            }
        }
    }
}