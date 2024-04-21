package com.finwise.feature.financialposition

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.finwise.feature.financialposition.details.financialPositionDetail
import com.finwise.feature.financialposition.details.navigateToFinancialPositionDetails
import com.finwise.feature.financialposition.overview.FINANCIAL_POSITION_ROUTE
import com.finwise.feature.financialposition.overview.financialPosition

const val FINANCIAL_POSITION_GRAPH = "financial-position-graph"

fun NavGraphBuilder.financialPositionNavGraph(
    navController: NavHostController,
) {
    navigation(
        route = FINANCIAL_POSITION_GRAPH,
        startDestination = FINANCIAL_POSITION_ROUTE,
    ) {
        financialPosition(navController::navigateToFinancialPositionDetails)

        financialPositionDetail()
    }
}
