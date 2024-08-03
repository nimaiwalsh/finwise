package com.finwise.feature.calculators

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.dialog
import androidx.navigation.navigation
import com.finwise.feature.calculators.compoundinterest.CalculatorCompoundInterestDestination
import com.finwise.feature.calculators.compoundinterest.CompoundInterestCalculatorScreen
import com.finwise.feature.calculators.compoundinterest.CompoundInterestViewModel
import com.finwise.feature.calculators.compoundinterest.calculatorCompoundInterestScreen
import com.finwise.feature.calculators.home.CalculatorsDestination
import com.finwise.feature.calculators.home.calculatorsScreen
import kotlinx.serialization.Serializable

@Serializable
object CalculatorsGraph

fun NavGraphBuilder.calculatorsNavGraph(
    navController: NavHostController,
) {
    navigation<CalculatorsGraph>(
        startDestination = CalculatorsDestination,
    ) {
        calculatorsScreen(
            onNavigateToCompoundInterest = { navController.navigate(CalculatorCompoundInterestDestination) },
        )
        calculatorCompoundInterestScreen(
            onNavigateBack = { navController.popBackStack() }
        )
    }
}
