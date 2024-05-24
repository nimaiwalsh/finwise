package com.finwise.feature.financialposition.overview

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object FinancialPositionDestination

fun NavGraphBuilder.financialPosition(
    onNavigateToFinancialPositionDetails: (financialPositionId: String) -> Unit,
) {
    composable<FinancialPositionDestination> {
        FinancialPositionScreen(
            navigateToFinancialPositionDetail = onNavigateToFinancialPositionDetails
        )
    }
}