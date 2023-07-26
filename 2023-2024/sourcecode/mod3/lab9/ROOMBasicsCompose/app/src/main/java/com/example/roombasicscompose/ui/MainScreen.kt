package com.example.roombasicscompose.ui

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roombasicscompose.data.User
import com.example.roombasicscompose.data.dummydata.DataProvider
import com.example.roombasicscompose.viewmodel.UserViewModel
import com.example.roombasicscompose.viewmodel.UserViewModelFactory

@Composable
fun MainScreen(){
    //var firstName by remember { mutableStateOf("") }
    //var lastName by remember { mutableStateOf("") }

    val viewModel: UserViewModel = viewModel(
        LocalViewModelStoreOwner.current!!,
        "UserViewModel",
        UserViewModelFactory(LocalContext.current.applicationContext as Application)
    )
    val users by viewModel.usersState.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(0.7f)
        ) {
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

        Button(
            onClick = { viewModel.addUser(DataProvider.user) },
            modifier = Modifier.fillMaxWidth().padding(4.dp)
        ) {
            Text(text = "ADD")
        }

        Button(
            onClick = { viewModel.clearUsers() },
            modifier = Modifier.fillMaxWidth().padding(4.dp)
        ) {
            Text(text = "CLEAR")
        }
    }
}