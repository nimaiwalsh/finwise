package com.finwise.feature.financialposition

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.financialPositionNavGraph(
    navController: NavHostController,
) {
    navigation(
        route = FinancialPositionScreen.Graph.route,
        startDestination = FinancialPositionScreen.Overview.route,
    ) {
        composable(
            route = FinancialPositionScreen.Overview.route
        ) {
            FinancialPositionScreen()
        }
    }
}

sealed class FinancialPositionScreen(val route: String) {
    object Graph : FinancialPositionScreen("financial_position_graph")
    object Overview : FinancialPositionScreen("financial_position_overview")
    object Detail : FinancialPositionScreen("financial_position_details")
}
