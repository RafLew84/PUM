package com.example.sharedpreferencesbasicscompose.ui

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sharedpreferencesbasicscompose.data.dummydata.DataProvider
import com.example.sharedpreferencesbasicscompose.viewmodel.UserViewModel
import com.example.sharedpreferencesbasicscompose.viewmodel.UserViewModelFactory

@Composable
fun MainScreen(){

    val viewModel: UserViewModel = viewModel(
        LocalViewModelStoreOwner.current!!,
        "UserViewModel",
        UserViewModelFactory(LocalContext.current.applicationContext as Application)
    )
    val currentUsername by viewModel.username.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Current saved username: $currentUsername",
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )

        Button(
            onClick = { viewModel.addUsername(DataProvider.username) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Text(text = "ADD")
        }

        Button(
            onClick = { viewModel.clearUsername() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Text(text = "CLEAR")
        }
    }
}