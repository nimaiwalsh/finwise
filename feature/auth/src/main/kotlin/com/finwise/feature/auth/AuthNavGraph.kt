package com.finwise.feature.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.finwise.feature.auth.login.LoginDestination
import com.finwise.feature.auth.login.loginScreen
import com.finwise.feature.auth.signup.SignupDestination
import com.finwise.feature.auth.signup.signupScreen
import kotlinx.serialization.Serializable

@Serializable
object AuthGraph

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
    navigateToMain: () -> Unit,
) {
    navigation<AuthGraph>(
        startDestination = LoginDestination,
    ) {
        loginScreen(
            onNavigateToMain = navigateToMain,
            onNavigateToSignUp = { navController.navigate(SignupDestination) },
        )

        signupScreen(
            onNavigateBack = { navController.popBackStack() }
        )
    }
}
