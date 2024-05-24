package com.finwise.feature

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.finwise.feature.newsfeed.NewsFeedDestination
import com.finwise.feature.newsfeed.newsfeedScreen
import kotlinx.serialization.Serializable

@Serializable
object NewsFeedGraph

fun NavGraphBuilder.newsFeedNavGraph(
    navController: NavHostController,
) {
    navigation<NewsFeedGraph>(
        startDestination = NewsFeedDestination,
    ) {
        newsfeedScreen()
    }
}
