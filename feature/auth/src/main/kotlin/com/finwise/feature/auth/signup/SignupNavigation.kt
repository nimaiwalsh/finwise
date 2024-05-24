package com.finwise.feature.auth.signup

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object SignupDestination

fun NavGraphBuilder.signupScreen(
    onNavigateBack: () -> Unit,
) {
    composable<SignupDestination> {
        val viewModel: SignUpViewModel = hiltViewModel()

        SignupScreen(onBackClicked = onNavigateBack)
    }
}