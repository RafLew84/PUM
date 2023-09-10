package com.example.repositorybasicscompose.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.repositorybasicscompose.viewmodel.UserViewModel


@Composable
fun MainScreen() {

    val viewModel: UserViewModel = viewModel()
    val users by viewModel.usersList.collectAsStateWithLifecycle()

    LazyColumn() {
        items(users.size) {
            Text(
                text = "${users[it].firstName} ${users[it].lastName}",
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
            )
        }
    }
}