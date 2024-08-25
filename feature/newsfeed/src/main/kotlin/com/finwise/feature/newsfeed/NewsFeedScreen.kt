package com.finwise.feature.newsfeed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.finwise.core.model.financenews.NewsItem
import com.finwise.core.ui.theme.FinWiseAppTheme

@Composable
fun NewsfeedScreen(
    newsItems: List<NewsItem>,
) {
    FinWiseAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxSize()
                    .wrapContentSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn {
                    items(
                        count = newsItems.size,
                        key = { index -> newsItems[index].id },
                    ) {
                        Text(text = newsItems[it].title)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_NewsFeedScreen() {
    FinWiseAppTheme {
        NewsfeedScreen(
            newsItems = listOf(
                NewsItem(
                    id = "1",
                    title = "News item 1"
                ),
                NewsItem(
                    id = "2",
                    title = "News item 2"
                )
            ),
        )
    }
}
