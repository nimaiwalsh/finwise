package com.finwise.feature.financialposition

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
            FinancialPositionScreen(
                navigateToFinancialPositionDetail = { financialPositionId ->
                    val route = FinancialPositionScreen.Detail.createRoute(financialPositionId = financialPositionId)
                    navController.navigate(route)
                }
            )
        }

        composable(
            route = FinancialPositionScreen.Detail.route,
            arguments = FinancialPositionScreen.Detail.navArguments,
        ) { navBackStackEntry ->
            val financialPositionId = navBackStackEntry.arguments?.getString(ArgParams.FINANCIAL_POSITION_ID)

            checkNotNull(financialPositionId) { "need a financial position id to open the page" }

            FinancialPositionDetailScreen(financialPositionId = financialPositionId)
        }
    }
}

sealed class FinancialPositionScreen(val route: String, val navArguments: List<NamedNavArgument> = emptyList()) {
    object Graph : FinancialPositionScreen("financialPosition_graph")
    object Overview : FinancialPositionScreen("financialPosition_overview")

    object Detail : FinancialPositionScreen(
        route = "financialPosition_detail/{${ArgParams.FINANCIAL_POSITION_ID}}",
        navArguments = listOf(
            navArgument(ArgParams.FINANCIAL_POSITION_ID) { type = NavType.StringType },
        ),
    ) {
        fun createRoute(financialPositionId: String) =
            route.replace(ArgParams.toPath(ArgParams.FINANCIAL_POSITION_ID), financialPositionId)
    }
}

object ArgParams {
    const val FINANCIAL_POSITION_ID = "financialPositionId"

    fun toPath(param: String) = "{${param}}"
}
