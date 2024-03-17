package com.finwise.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.finwise.android.navigation.RootNavHost
import com.finwise.core.ui.theme.FinWiseAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            FinWiseAppTheme {
                MainScreenContent(isAuthenticated = viewModel.isAuthenticated)
            }
        }
    }
}

@Composable
private fun MainScreenContent(isAuthenticated: Boolean) {
    RootNavHost(isAuthenticated = isAuthenticated)
}
