package com.finwise.android.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.finwise.feature.auth.AuthGraph
import com.finwise.feature.auth.authNavGraph

@Composable
fun RootNavHost(isAuthenticated: Boolean) {
    val rootNavController = rememberNavController()
    val rootNavBackStackEntry by rootNavController.currentBackStackEntryAsState()
    val currentRoute = rootNavBackStackEntry?.destination?.route

    val snackBarHostState = remember { SnackbarHostState() }

    val bottomBarState = rememberSaveable { mutableStateOf(true) }
    val topBarState = rememberSaveable { mutableStateOf(true) }

    // Control TopBar and BottomBar
    when (currentRoute) {
        TopLevelDestination.Home.route -> {
            bottomBarState.value = true
            topBarState.value = true
        }
        TopLevelDestination.Calculators.route -> {
            bottomBarState.value = true
            topBarState.value = true
        }
        TopLevelDestination.NewsFeed.route -> {
            bottomBarState.value = true
            topBarState.value = true
        }
        TopLevelDestination.FinancialPosition.route -> {
            bottomBarState.value = true
            topBarState.value = true
        }
        else -> {
            bottomBarState.value = false
            topBarState.value = false
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
        bottomBar = {
            if (bottomBarState.value) {
                BottomNavBar(
                    navController = rootNavController,
                    navigationScreens = listOf(
                        TopLevelDestination.Home,
                        TopLevelDestination.Calculators,
                        TopLevelDestination.NewsFeed,
                        TopLevelDestination.FinancialPosition
                    )
                )
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            RootNavHost(
                rootNavController = rootNavController,
                isAuthenticated = isAuthenticated,
            )
        }
    }
}

@Composable
private fun RootNavHost(
    rootNavController: NavHostController,
    isAuthenticated: Boolean,
) {
    NavHost(
        navController = rootNavController,
        startDestination = if (isAuthenticated) MainGraph else AuthGraph,
        enterTransition = {
            // you can change whatever you want transition
            EnterTransition.None
        },
        exitTransition = {
            // you can change whatever you want transition
            ExitTransition.None
        }
    ) {
        authNavGraph(
            navController = rootNavController,
            navigateToMain = {
                rootNavController.navigate(MainGraph) {
                    popUpTo(AuthGraph) {
                        inclusive = true
                    }
                }
            },
        )
        mainNavGraph(
            navController = rootNavController,
            navigateToLogin = {
                rootNavController.navigate(AuthGraph) {
                    popUpTo(MainGraph) {
                        inclusive = true
                    }
                }
            }
        )
    }
}
