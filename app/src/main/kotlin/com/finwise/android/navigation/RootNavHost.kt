package com.finwise.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.finwise.feature.financialposition.FinancialPositionScreen
import com.finwise.feature.home.HomeScreen
import com.finwise.feature.login.LoginScreen

@Composable
fun RootNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRouter.Screen.Login.route,
    ) {
        composable(route = AppRouter.Screen.Login.route) {
            LoginScreen(navigateToHome = { navController.navigate(AppRouter.Screen.Home.route) })
        }

        composable(route = AppRouter.Screen.Home.route) {
            HomeScreen(
                onFinancialPositionClicked = { financialPositionId ->
                    val route = AppRouter.Screen.FinancialPosition.createRoute(financialPositionId = financialPositionId)
                    navController.navigate(route)
                }
            )
        }

        composable(route = AppRouter.Screen.FinancialPosition.route) { navBackStackEntry ->
            val financialPositionId = navBackStackEntry.arguments?.getString(AppRouter.ArgParams.FINANCIAL_POSITION_ID)

            checkNotNull(financialPositionId) { "need a financial position id to open the page"}

            FinancialPositionScreen(financialPositionId = financialPositionId)
        }
    }
}