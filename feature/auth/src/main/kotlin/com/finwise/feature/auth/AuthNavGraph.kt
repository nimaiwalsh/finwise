package com.finwise.feature.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.finwise.feature.auth.login.LOGIN_ROUTE
import com.finwise.feature.auth.login.loginScreen
import com.finwise.feature.auth.signup.navigateToSignup
import com.finwise.feature.auth.signup.signupScreen

const val AUTH_GRAPH = "auth-graph"

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
    navigateToMain: () -> Unit,
) {
    navigation(
        route = AUTH_GRAPH,
        startDestination = LOGIN_ROUTE,
    ) {
        loginScreen(
            onNavigateToMain = navigateToMain,
            onNavigateToSignUp = { navController.navigateToSignup() },
        )

        signupScreen(
            onNavigateBack = { navController.popBackStack() }
        )
    }
}
