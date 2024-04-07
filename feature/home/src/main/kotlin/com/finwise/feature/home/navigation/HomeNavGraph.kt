package com.finwise.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.finwise.feature.home.HOME_ROUTE
import com.finwise.feature.home.homeScreen

const val HOME_GRAPH_ROUTE = "home-graph"

fun NavController.navigateToHomeGraph() {
    navigate(HOME_GRAPH_ROUTE)
}

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController,
    onNavigateToLogin: () -> Unit,
) {
    navigation(
        route = HOME_GRAPH_ROUTE,
        startDestination = HOME_ROUTE,
    ) {
        homeScreen(
            onNavigateBack = { navController.popBackStack() },
            onNavigateToLogin = onNavigateToLogin
        )
    }
}
