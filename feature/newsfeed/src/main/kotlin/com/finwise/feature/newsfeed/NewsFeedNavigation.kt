package com.finwise.feature.newsfeed

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object NewsFeedDestination

fun NavGraphBuilder.newsfeedScreen() {
    composable<NewsFeedDestination> {
        NewsfeedScreen()
    }
}