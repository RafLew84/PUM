package com.example.jetpackcomposepagerwithtabsbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.jetpackcomposepagerwithtabsbasics.ui.theme.JetpackComposePagerWithTabsBasicsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePagerWithTabsBasicsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainLayout()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainLayout() {
    val data = listOf(
        "Tab 1" to Icons.Filled.Home,
        "Tab 2" to Icons.Filled.Person,
        "Tab 3" to Icons.Filled.Phone,
        "Tab 4" to Icons.Filled.Email,
    )

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        Tabs(pagerState = pagerState, coroutineScope = coroutineScope, data = data)
        Pages(pagerState = pagerState, data = data)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs(
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
    data: List<Pair<String, ImageVector>>
) {
    TabRow(
        selectedTabIndex = pagerState.currentPage,
    ) {
        data.forEachIndexed { index, pair ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                text = { Text(text = pair.first) },
                icon = { Icon(imageVector = pair.second, contentDescription = null) }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pages(pagerState: PagerState, data: List<Pair<String, ImageVector>>) {
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        pageCount = data.size,
        pageSize = PageSize.Fill
    ) { index ->
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = data[index].first,
            )
        }
    }
}

