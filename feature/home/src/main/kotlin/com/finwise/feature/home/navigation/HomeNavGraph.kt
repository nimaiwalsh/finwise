package com.finwise.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.finwise.feature.home.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController,
    navigateToFinancialPosition: (financialPositionId: String) -> Unit,
    navigateToLogin: () -> Unit,
) {
    navigation(
        route = HomeScreen.Graph.route,
        startDestination = HomeScreen.Home.route,
    ) {
        composable(
            route = HomeScreen.Home.route,
        ) {
            HomeScreen(
                onFinancialPositionClicked = navigateToFinancialPosition,
                // route back to auth graph
                navigateToLogin = navigateToLogin,
            )
        }
    }
}

sealed class HomeScreen(val route: String) {
    object Graph : HomeScreen("home_graph")
    object Home : HomeScreen("home")
}