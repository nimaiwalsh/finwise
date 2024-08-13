package com.finwise.feature.calculators.compoundinterest

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object CalculatorCompoundInterestDestination

fun NavGraphBuilder.calculatorCompoundInterestScreen(
    onNavigateBack: () -> Unit,
) {
    composable<CalculatorCompoundInterestDestination> {
        val viewModel: CompoundInterestViewModel = hiltViewModel()

        CompoundInterestCalculatorScreen(welcomeText = viewModel.title)
    }
}