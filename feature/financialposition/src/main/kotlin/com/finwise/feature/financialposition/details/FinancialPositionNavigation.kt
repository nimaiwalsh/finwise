package com.finwise.feature.financialposition.details

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

const val FINANCIAL_POSITION_DETAILS_ROUTE = "financialPosition_detail/{${FinancialPositionDetailsArgParams.FINANCIAL_POSITION_ID}}"

fun NavController.navigateToFinancialPositionDetails(
    financialPositionId: String,
) {
    val route = FinancialPositionDetailsArgParams.createRoute(financialPositionId = financialPositionId)
    navigate(route)
}

fun NavGraphBuilder.financialPositionDetail() {
    composable(
        route = FINANCIAL_POSITION_DETAILS_ROUTE,
        arguments = listOf(
            navArgument(FinancialPositionDetailsArgParams.FINANCIAL_POSITION_ID) { type = NavType.StringType },
        ),
    ) { navBackStackEntry ->
        // too access the argument directly from composable
        val financialPositionId = navBackStackEntry.arguments?.getString(FinancialPositionDetailsArgParams.FINANCIAL_POSITION_ID)

        val viewModel: FinancialPositionDetailViewModel = hiltViewModel()

        FinancialPositionDetailScreen(welcomeText = viewModel.title)
    }
}

object FinancialPositionDetailsArgParams {
    const val FINANCIAL_POSITION_ID = "financialPositionId"

    fun createRoute(financialPositionId: String) =
        FINANCIAL_POSITION_DETAILS_ROUTE.replace("{${FINANCIAL_POSITION_ID}}", financialPositionId)
}
