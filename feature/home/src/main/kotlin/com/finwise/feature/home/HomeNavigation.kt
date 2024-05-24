package com.finwise.feature.home

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object HomeDestination

fun NavGraphBuilder.homeScreen(
    onNavigateBack: () -> Unit,
    onNavigateToLogin: () -> Unit,
) {
    composable<HomeDestination> {
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