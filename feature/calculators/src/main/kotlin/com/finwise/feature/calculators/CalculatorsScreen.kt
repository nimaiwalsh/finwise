package com.finwise.feature.calculators

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.finwise.core.ui.theme.FinWiseAppTheme

const val CALCULATORS_ROUTE = "calculators"

fun NavController.navigateToCalculatorsScreen() {
    navigate(CALCULATORS_ROUTE)
}

fun NavGraphBuilder.calculatorsScreen(
    onNavigateToCompoundInterest: () -> Unit,
) {
    composable(route = CALCULATORS_ROUTE) {
        CalculatorsScreen(
            onCompoundInterestButtonClicked = onNavigateToCompoundInterest
        )
    }
}

@Composable
fun CalculatorsScreen(
    onCompoundInterestButtonClicked: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize()
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.size(24.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onCompoundInterestButtonClicked,
            ) {
                Text("CompoundInterest")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    FinWiseAppTheme {
        CalculatorsScreen(onCompoundInterestButtonClicked = {})
    }
}