package com.finwise.feature

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.finwise.feature.home.HomeDestination
import com.finwise.feature.home.homeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeGraph

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController,
    onNavigateToLogin: () -> Unit,
) {
    navigation<HomeGraph>(
        startDestination = HomeDestination,
    ) {
        homeScreen(
            onNavigateBack = { navController.popBackStack() },
            onNavigateToLogin = onNavigateToLogin
        )
    }
}
