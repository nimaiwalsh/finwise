package com.finwise.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.finwise.android.navigation.RootNavHost
import com.finwise.core.ui.navigation.AppScreen
import com.finwise.core.ui.reusablecomponents.BottomNavBar
import com.finwise.core.ui.theme.FinWiseAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            FinWiseAppTheme {
                navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val scope = rememberCoroutineScope()
                val snackBarHostState = remember { SnackbarHostState() }

                val bottomBarState = rememberSaveable { mutableStateOf(true) }
                val topBarState = rememberSaveable { mutableStateOf(true) }

                // Control TopBar and BottomBar
                when (navBackStackEntry?.destination?.route) {
                    AppScreen.Main.Home.route -> {
                        bottomBarState.value = true
                        topBarState.value = true
                    }
                    AppScreen.Main.Calculators.route -> {
                        bottomBarState.value = true
                        topBarState.value = true
                    }
                    AppScreen.Main.NewsFeed.route -> {
                        bottomBarState.value = true
                        topBarState.value = true
                    }
                    AppScreen.Main.FinancialPosition.route -> {
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
                            BottomNavBar(navController = navController)
                        }
                    }
                ) { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)) {
                        RootNavHost(navHostController = navController)
                    }
                }
            }
        }
    }
}
