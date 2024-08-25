package com.finwise.feature.newsfeed

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object NewsFeedDestination

fun NavGraphBuilder.newsfeedScreen() {
    composable<NewsFeedDestination> {
        val viewModel: NewsFeedViewModel = hiltViewModel()
        val state by viewModel.state.collectAsState()

        NewsfeedScreen(newsItems = state.newsItems)
    }
}