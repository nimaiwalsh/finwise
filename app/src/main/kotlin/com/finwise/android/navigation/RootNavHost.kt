package com.finwise.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.finwise.core.ui.navigation.AppScreen

@Composable
fun RootNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = AppScreen.Auth.route,
    ) {
        authNavGraph(navHostController)
        mainNavGraph(navHostController)
    }
}