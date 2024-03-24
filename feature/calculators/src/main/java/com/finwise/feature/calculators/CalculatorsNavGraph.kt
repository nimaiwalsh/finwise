package com.finwise.feature.calculators

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.finwise.feature.calculators.compoundinterest.CompoundInterestCalculatorScreen

fun NavGraphBuilder.calculatorsNavGraph(
    navController: NavHostController,
) {
    navigation(
        route = NavGraph.CALCULATOR_GRAPH,
        startDestination = CalculatorScreen.Calculators.route,
    ) {
        composable(
            route = CalculatorScreen.Calculators.route,
        ) {
            CalculatorsScreen()
        }
        composable(
            route = CalculatorScreen.CompoundInterest.route,
        ) {
            CompoundInterestCalculatorScreen()
        }
    }
}

object NavGraph {
    const val CALCULATOR_GRAPH = "calculator_graph"
}

sealed class CalculatorScreen(val route: String) {
    object Calculators : CalculatorScreen("calculators")
    object CompoundInterest : CalculatorScreen("compound_interest")
}
