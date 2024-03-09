package com.finwise.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.finwise.feature.home.HomeScreen
import com.finwise.feature.login.LoginScreen

@Composable
fun RootNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRouter.Screen.Login.route,
    ) {
        composable(AppRouter.Screen.Login.route) {
            LoginScreen(navigateToHome = { navController.navigate(AppRouter.Screen.Home.route) })
        }

        composable(AppRouter.Screen.Home.route) {
            HomeScreen()
        }
    }
}