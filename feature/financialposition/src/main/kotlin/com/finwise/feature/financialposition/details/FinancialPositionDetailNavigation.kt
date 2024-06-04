package com.finwise.feature.financialposition.details

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
data class FinancialPositionDetailDestination(val financialPositionId: String)

fun NavController.navigateToFinancialPositionDetails(financialPositionId: String) {
    navigate(FinancialPositionDetailDestination(financialPositionId))
}

fun NavGraphBuilder.financialPositionDetail() {
    composable<FinancialPositionDetailDestination> {navBackStackEntry ->
        // too access the argument directly from composable
        val financialPositionId = navBackStackEntry.toRoute<FinancialPositionDetailDestination>().financialPositionId

        val viewModel: FinancialPositionDetailViewModel = hiltViewModel()

        FinancialPositionDetailScreen(welcomeText = viewModel.title)
    }
}
