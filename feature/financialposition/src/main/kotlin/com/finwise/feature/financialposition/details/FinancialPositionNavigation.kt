package com.finwise.feature.financialposition.details

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

const val FINANCIAL_POSITION_DETAILS_ROUTE = "financialPosition_detail/{${ArgParams.FINANCIAL_POSITION_ID}}"

fun NavController.navigateToFinancialPositionDetails(
    financialPositionId: String,
) {
    val route = ArgParams.createRoute(financialPositionId = financialPositionId)
    navigate(route)
}

fun NavGraphBuilder.financialPositionDetail() {
    composable(
        route = FINANCIAL_POSITION_DETAILS_ROUTE,
        arguments = listOf(
            navArgument(ArgParams.FINANCIAL_POSITION_ID) { type = NavType.StringType },
        ),
    ) { navBackStackEntry ->
        val financialPositionId = navBackStackEntry.arguments?.getString(ArgParams.FINANCIAL_POSITION_ID)
        checkNotNull(financialPositionId) { "need a financial position id to open the page" }

        val viewModel: FinancialPositionDetailViewModel = hiltViewModel()

        FinancialPositionDetailScreen(financialPositionId = financialPositionId)
    }
}

object ArgParams {
    const val FINANCIAL_POSITION_ID = "financialPositionId"

    private fun toPath(param: String) = "{${param}}"

    fun createRoute(financialPositionId: String) =
        FINANCIAL_POSITION_DETAILS_ROUTE.replace(toPath(FINANCIAL_POSITION_ID), financialPositionId)
}
