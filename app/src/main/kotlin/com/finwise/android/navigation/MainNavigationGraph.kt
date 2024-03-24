package com.finwise.android.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.finwise.feature.calculators.calculatorsNavGraph
import com.finwise.feature.financialposition.financialPositionNavGraph
import com.finwise.feature.home.navigation.HomeScreen
import com.finwise.feature.home.navigation.homeNavGraph
import com.finwise.feature.newsfeed.newsFeedNavGraph

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
    navigateToLogin: () -> Unit,
) {
    navigation(
        route = AppScreen.Main.route,
        startDestination = HomeScreen.Graph.route,
    ) {

        homeNavGraph(
            navController = navController,
            navigateToLogin = navigateToLogin,
        )

        calculatorsNavGraph(navController = navController)

        newsFeedNavGraph(navController = navController)

        financialPositionNavGraph(navController = navController)
    }
}