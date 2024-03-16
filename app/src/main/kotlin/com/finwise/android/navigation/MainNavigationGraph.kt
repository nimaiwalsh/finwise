package com.finwise.android.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.finwise.core.ui.navigation.AppScreen
import com.finwise.core.ui.navigation.ArgParams
import com.finwise.feature.calculators.CalculatorsScreen
import com.finwise.feature.financialposition.FinancialPositionScreen
import com.finwise.feature.home.HomeScreen
import com.finwise.feature.newsfeed.NewsfeedScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
) {
    navigation(
        route = AppScreen.Main.route,
        startDestination = AppScreen.Main.Home.route,
    ) {
        composable(
            route = AppScreen.Main.Home.route,
        ) {
            HomeScreen(
                onFinancialPositionClicked = { financialPositionId ->
                    val route = AppScreen.FinancialPositionDetail.createRoute(financialPositionId = financialPositionId)
                    navController.navigate(route)
                },
                // route back to auth graph
                navigateToLogin = {
                    navController.navigate(AppScreen.Auth.route) {
                        popUpTo(AppScreen.Main.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(
            route = AppScreen.Main.Calculators.route,
        ) {
            CalculatorsScreen()
        }

        composable(
            route = AppScreen.Main.NewsFeed.route
        ) {
            NewsfeedScreen()
        }

        composable(
            route = AppScreen.Main.FinancialPosition.route
        ) {
            FinancialPositionScreen()
        }

        composable(route = AppScreen.FinancialPositionDetail.route) { navBackStackEntry ->
            val financialPositionId = navBackStackEntry.arguments?.getString(ArgParams.FINANCIAL_POSITION_ID)

            checkNotNull(financialPositionId) { "need a financial position id to open the page"}

            FinancialPositionScreen(financialPositionId = financialPositionId)
        }
    }
}