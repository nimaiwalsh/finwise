package com.finwise.feature.calculators

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.finwise.feature.calculators.compoundinterest.calculatorCompoundInterestScreen
import com.finwise.feature.calculators.compoundinterest.navigateToCalculatorCompoundInterestScreen

const val CALCULATORS_GRAPH = "calculators-graph"

fun NavGraphBuilder.calculatorsNavGraph(
    navController: NavHostController,
) {
    navigation(
        route = CALCULATORS_GRAPH,
        startDestination = CALCULATORS_ROUTE,
    ) {
        calculatorsScreen(
            onNavigateToCompoundInterest = { navController.navigateToCalculatorCompoundInterestScreen() }
        )
        calculatorCompoundInterestScreen(
            onNavigateBack = { navController.popBackStack() }
        )
    }
}
