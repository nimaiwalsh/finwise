package com.finwise.android.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.finwise.feature.login.navigation.AUTH_GRAPH
import com.finwise.feature.login.navigation.authNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootNavHost(isAuthenticated: Boolean) {
    val rootNavController = rememberNavController()
    val rootNavBackStackEntry by rootNavController.currentBackStackEntryAsState()
    val currentRoute = rootNavBackStackEntry?.destination?.route

    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    val bottomBarState = rememberSaveable { mutableStateOf(true) }
    val topBarState = rememberSaveable { mutableStateOf(true) }

    // Control TopBar and BottomBar
    when (rootNavBackStackEntry?.destination?.route) {
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
        startDestination = if (isAuthenticated) MAIN_GRAPH else AUTH_GRAPH,
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
                rootNavController.navigate(MAIN_GRAPH) {
                    popUpTo(AUTH_GRAPH) {
                        inclusive = true
                    }
                }
            },
        )
        mainNavGraph(
            navController = rootNavController,
            navigateToLogin = {
                rootNavController.navigate(AUTH_GRAPH) {
                    popUpTo(MAIN_GRAPH) {
                        inclusive = true
                    }
                }
            }
        )
    }
}
