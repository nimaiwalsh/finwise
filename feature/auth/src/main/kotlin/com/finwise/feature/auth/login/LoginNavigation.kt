package com.finwise.feature.auth.login

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val LOGIN_ROUTE = "login"

fun NavController.navigateToLoginScreen() {
    navigate(LOGIN_ROUTE)
}

fun NavGraphBuilder.loginScreen(
    onNavigateToMain: () -> Unit,
    onNavigateToSignUp: () -> Unit,
) {
    composable(route = LOGIN_ROUTE) {
        val viewModel: LoginViewModel = hiltViewModel()

        LoginScreen(
            loginButtonClicked = onNavigateToMain,
            signUpButtonClicked = onNavigateToSignUp,
        )
    }
}