package com.finwise.feature.newsfeed

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation

const val NEWSFEED_GRAPH = "newsfeed-graph"

fun NavGraphBuilder.newsFeedNavGraph(
    navController: NavHostController,
) {
    navigation(
        route = NEWSFEED_GRAPH,
        startDestination = NEWSFEED_ROUTE,
    ) {
        newsfeedScreen()
    }
}
