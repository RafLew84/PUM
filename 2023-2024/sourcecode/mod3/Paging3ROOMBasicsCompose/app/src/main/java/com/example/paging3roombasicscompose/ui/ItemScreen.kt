package com.example.paging3roombasicscompose.ui

import android.app.Application
import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.paging3roombasicscompose.viewmodel.ItemViewModel
import com.example.paging3roombasicscompose.viewmodel.ItemViewModelFactory
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.paging.LoadState
import kotlinx.coroutines.delay


@Composable
fun ItemScreen() {
    val viewModel: ItemViewModel = viewModel(
        LocalViewModelStoreOwner.current!!,
        "ItemViewModel",
        ItemViewModelFactory(LocalContext.current.applicationContext as Application)
    )

    val lazyPagingItems = viewModel.items.collectAsLazyPagingItems()

    LazyColumn {
        items(lazyPagingItems.itemCount) { index ->
            Text(
                text = lazyPagingItems[index]?.name ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        lazyPagingItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> item {
                    CircularProgressIndicator(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                loadState.append is LoadState.Loading -> item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                loadState.refresh is LoadState.Error -> item {
                    Text(
                        text = "Błąd podczas odświeżania",
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        color = MaterialTheme.colorScheme.error
                    )
                }
                loadState.append is LoadState.Error -> item {
                    // Handle error when loading next page
                }
            }
        }
    }
}