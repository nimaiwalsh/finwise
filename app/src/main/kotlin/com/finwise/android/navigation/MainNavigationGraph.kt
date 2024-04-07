package com.finwise.android.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.finwise.feature.calculators.calculatorsNavGraph
import com.finwise.feature.financialposition.financialPositionNavGraph
import com.finwise.feature.home.navigation.HOME_GRAPH_ROUTE
import com.finwise.feature.home.navigation.homeNavGraph
import com.finwise.feature.newsfeed.newsFeedNavGraph

const val MAIN_GRAPH = "main-graph"

fun NavController.navigateToMainNavGraph() {
    navigate(MAIN_GRAPH) {
        popUpTo(AppScreen.Auth.route) {
            inclusive = true
        }
    }
}

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
    navigateToLogin: () -> Unit,
) {
    navigation(
        route = AppScreen.Main.route,
        startDestination = HOME_GRAPH_ROUTE,
    ) {

        homeNavGraph(
            navController = navController,
            onNavigateToLogin = navigateToLogin,
        )

        calculatorsNavGraph(navController = navController)

        newsFeedNavGraph(navController = navController)

        financialPositionNavGraph(navController = navController)
    }
}