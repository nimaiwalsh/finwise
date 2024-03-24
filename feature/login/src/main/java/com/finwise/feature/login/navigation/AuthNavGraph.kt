package com.finwise.feature.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.finwise.feature.login.LoginScreen
import com.finwise.feature.login.SignupScreen

fun NavGraphBuilder.authNavGraph(
    navigateToMain: () -> Unit,
    navController: NavHostController,
) {
    navigation(
        route = AuthScreen.Graph.route,
        startDestination = AuthScreen.Login.route,
    ) {
        composable(
            route = AuthScreen.Login.route,
        ) {
            LoginScreen(
                navigateToMain = navigateToMain,
                navigateToSignUp = {
                    navController.navigate(AuthScreen.Register.route)
                }
            )
        }

        composable(
            route = AuthScreen.Register.route,
        ) {
            SignupScreen(
                onBackClicked = { navController.navigateUp() },
            )
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Graph : AuthScreen("auth_graph")
    object Login : AuthScreen("login")
    object Register : AuthScreen("register")
}
