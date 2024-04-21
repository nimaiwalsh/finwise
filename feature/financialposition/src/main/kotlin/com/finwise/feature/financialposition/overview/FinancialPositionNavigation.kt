package com.finwise.feature.financialposition.overview

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val FINANCIAL_POSITION_ROUTE = "financialPosition"

fun NavController.navigateToFinancialPosition() {
    navigate(FINANCIAL_POSITION_ROUTE)
}

fun NavGraphBuilder.financialPosition(
    onNavigateToFinancialPositionDetails: (financialPositionId: String) -> Unit,
) {
    composable(route = FINANCIAL_POSITION_ROUTE) {
        FinancialPositionScreen(
            navigateToFinancialPositionDetail = onNavigateToFinancialPositionDetails
        )
    }
}