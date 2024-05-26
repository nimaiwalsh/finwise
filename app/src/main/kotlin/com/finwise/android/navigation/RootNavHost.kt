package com.finwise.android.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
            materialSharedAxisZIn(forward = true)
        },
        exitTransition = {
            // you can change whatever you want transition
            materialSharedAxisZOut(forward = true)
        },
        popEnterTransition = {
            materialSharedAxisZIn(forward = false)
        },
        popExitTransition = {
            materialSharedAxisZOut(forward = false)
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


private const val DEFAULT_MOTION_DURATION: Int = 300
private const val DEFAULT_SLIDE_DISTANCE: Int = 225
private const val FADE_DURATION_MULTIPLIER = 0.33f
private val Int.incomingFadeDuration: Int
    get() = (this * FADE_DURATION_MULTIPLIER).toInt()
private val Int.outgoingFadeDuration: Int
    get() = (this * FADE_DURATION_MULTIPLIER).toInt()

fun materialSharedAxisXIn(
    forward: Boolean,
    slideDistance: Int = DEFAULT_SLIDE_DISTANCE,
    durationMillis: Int = DEFAULT_MOTION_DURATION,
): EnterTransition = slideInHorizontally(
    animationSpec = tween(
        durationMillis = durationMillis,
        easing = FastOutSlowInEasing,
    ),
    initialOffsetX = {
        if (forward) slideDistance else -slideDistance
    },
) + fadeIn(
    animationSpec = tween(
        durationMillis = durationMillis.incomingFadeDuration,
        easing = LinearOutSlowInEasing,
    ),
)

fun materialSharedAxisXOut(
    forward: Boolean,
    slideDistance: Int = DEFAULT_SLIDE_DISTANCE,
    durationMillis: Int = DEFAULT_MOTION_DURATION,
): ExitTransition = slideOutHorizontally(
    animationSpec = tween(
        durationMillis = durationMillis,
        easing = FastOutSlowInEasing,
    ),
    targetOffsetX = {
        if (forward) -slideDistance else slideDistance
    },
) + fadeOut(
    animationSpec = tween(
        durationMillis = durationMillis.outgoingFadeDuration,
        easing = FastOutLinearInEasing,
    ),
)

fun materialSharedAxisZIn(
    forward: Boolean,
    durationMillis: Int = DEFAULT_MOTION_DURATION,
): EnterTransition = fadeIn(
    animationSpec = tween(
        durationMillis = durationMillis.incomingFadeDuration,
        easing = LinearOutSlowInEasing,
    ),
) + scaleIn(
    animationSpec = tween(
        durationMillis = durationMillis,
        easing = FastOutSlowInEasing,
    ),
    initialScale = if (forward) 0.8f else 1.1f,
)

fun materialSharedAxisZOut(
    forward: Boolean,
    durationMillis: Int = DEFAULT_MOTION_DURATION,
): ExitTransition = fadeOut(
    animationSpec = tween(
        durationMillis = durationMillis.outgoingFadeDuration,
        easing = FastOutLinearInEasing,
    ),
) + scaleOut(
    animationSpec = tween(
        durationMillis = durationMillis,
        easing = FastOutSlowInEasing,
    ),
    targetScale = if (forward) 1.1f else 0.8f,
)
