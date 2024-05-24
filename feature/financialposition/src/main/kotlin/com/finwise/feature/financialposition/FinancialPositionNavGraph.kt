package com.finwise.feature.financialposition

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.finwise.feature.financialposition.details.financialPositionDetail
import com.finwise.feature.financialposition.details.navigateToFinancialPositionDetails
import com.finwise.feature.financialposition.overview.FinancialPositionDestination
import com.finwise.feature.financialposition.overview.financialPosition
import kotlinx.serialization.Serializable

@Serializable
object FinancialPositionGraph

fun NavGraphBuilder.financialPositionNavGraph(
    navController: NavHostController,
) {
    navigation<FinancialPositionGraph>(
        startDestination = FinancialPositionDestination,
    ) {
        financialPosition(navController::navigateToFinancialPositionDetails)

        financialPositionDetail()
    }
}
