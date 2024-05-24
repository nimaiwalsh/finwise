package com.finwise.feature.calculators.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object CalculatorsDestination

fun NavGraphBuilder.calculatorsScreen(
    onNavigateToCompoundInterest: () -> Unit,
) {
    composable<CalculatorsDestination> {
        CalculatorsScreen(
            onCompoundInterestButtonClicked = onNavigateToCompoundInterest
        )
    }
}
