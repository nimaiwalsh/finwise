package com.finwise.android.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.finwise.feature.calculators.calculatorsNavGraph
import com.finwise.feature.financialposition.financialPositionNavGraph
import com.finwise.feature.home.HOME_GRAPH_ROUTE
import com.finwise.feature.home.homeNavGraph
import com.finwise.feature.newsfeed.newsFeedNavGraph

const val MAIN_GRAPH = "main-graph"

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
    navigateToLogin: () -> Unit,
) {
    navigation(
        route = MAIN_GRAPH,
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