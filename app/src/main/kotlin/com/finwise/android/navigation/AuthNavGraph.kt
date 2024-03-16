package com.finwise.android.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.finwise.core.ui.navigation.AppScreen
import com.finwise.feature.login.LoginScreen
import com.finwise.feature.login.SignupScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
) {
    navigation(
        route = AppScreen.Auth.route,
        startDestination = AppScreen.Auth.Login.route,
    ) {
        composable(
            route = AppScreen.Auth.Login.route
        ) {
            LoginScreen(
                navigateToHome = {
                    navController.navigate(AppScreen.Main.route)  {
                        popUpTo(AppScreen.Auth.route) {
                            inclusive = true
                        }
                    }
                },
                navigateToSignUp = {
                    navController.navigate(AppScreen.Auth.Register.route)
                }
            )
        }

        composable(
            route = AppScreen.Auth.Register.route
        ) {
            SignupScreen(
                onBackClicked = { navController.navigateUp() },
            )
        }
    }
}