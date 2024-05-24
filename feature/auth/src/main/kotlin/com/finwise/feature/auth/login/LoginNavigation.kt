package com.finwise.feature.auth.login

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object LoginDestination

fun NavGraphBuilder.loginScreen(
    onNavigateToMain: () -> Unit,
    onNavigateToSignUp: () -> Unit,
) {
    composable<LoginDestination> {
        val viewModel: LoginViewModel = hiltViewModel()

        LoginScreen(
            loginButtonClicked = onNavigateToMain,
            signUpButtonClicked = onNavigateToSignUp,
        )
    }
}