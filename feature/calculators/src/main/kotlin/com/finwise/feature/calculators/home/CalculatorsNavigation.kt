package com.finwise.feature.calculators.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val CALCULATORS_ROUTE = "calculators"

fun NavController.navigateToCalculatorsScreen() {
    navigate(CALCULATORS_ROUTE)
}

fun NavGraphBuilder.calculatorsScreen(
    onNavigateToCompoundInterest: () -> Unit,
) {
    composable(route = CALCULATORS_ROUTE) {
        CalculatorsScreen(
            onCompoundInterestButtonClicked = onNavigateToCompoundInterest
        )
    }
}
