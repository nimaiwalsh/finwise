package com.finwise.feature.calculators.compoundinterest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.finwise.core.ui.theme.FinWiseAppTheme

const val CALCULATOR_COMPOUND_INTEREST_ROUTE = "calculator-compound-interest"

fun NavController.navigateToCalculatorCompoundInterestScreen() {
    navigate(CALCULATOR_COMPOUND_INTEREST_ROUTE)
}

fun NavGraphBuilder.calculatorCompoundInterestScreen(
    onNavigateBack: () -> Unit,
) {
    composable(route = CALCULATOR_COMPOUND_INTEREST_ROUTE) {
        val viewModel: CompoundInterestViewModel = hiltViewModel()

        CompoundInterestCalculatorScreen(welcomeText = viewModel.title)
    }
}

@Composable
internal fun CompoundInterestCalculatorScreen(welcomeText: String) {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = welcomeText,
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.size(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    FinWiseAppTheme {
        CompoundInterestCalculatorScreen(welcomeText = "Welcome to compound interest")
    }
}
