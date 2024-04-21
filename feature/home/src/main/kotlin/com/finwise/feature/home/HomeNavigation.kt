package com.finwise.feature.home

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val HOME_ROUTE = "home"

fun NavController.navigateToHomeScreen() {
    navigate(HOME_ROUTE)
}

fun NavGraphBuilder.homeScreen(
    onNavigateBack: () -> Unit,
    onNavigateToLogin: () -> Unit,
) {
    composable(route = HOME_ROUTE) {
        // view models live as long as destinations in the NavHost,
        // which we create using composable(route) function.
        val viewModel: HomeViewModel = hiltViewModel()
        val state by viewModel.state.collectAsStateWithLifecycle()

        HomeScreen(
            onLogoutClicked = onNavigateToLogin,
            welcomeText = state.welcomeText,
        )
    }
}