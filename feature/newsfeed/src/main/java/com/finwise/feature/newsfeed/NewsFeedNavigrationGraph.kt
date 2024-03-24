package com.finwise.feature.newsfeed

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.newsFeedNavGraph(
    navController: NavHostController,
) {
    navigation(
        route = NewsScreen.Graph.route,
        startDestination = NewsScreen.NewsList.route,
    ) {
        composable(
            route = NewsScreen.NewsList.route,
        ) {
            NewsfeedScreen()
        }
    }
}

sealed class NewsScreen(val route: String) {
    object Graph : NewsScreen("news_graph")
    object NewsList : NewsScreen("news_list")
}