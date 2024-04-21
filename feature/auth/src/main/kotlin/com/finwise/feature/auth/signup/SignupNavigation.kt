package com.finwise.feature.auth.signup

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SIGNUP_ROUTE = "signup"

fun NavController.navigateToSignup() {
    navigate(SIGNUP_ROUTE)
}

fun NavGraphBuilder.signupScreen(
    onNavigateBack: () -> Unit,
) {
    composable(route = SIGNUP_ROUTE) {
        val viewModel: SignUpViewModel = hiltViewModel()

        SignupScreen(onBackClicked = onNavigateBack)
    }
}