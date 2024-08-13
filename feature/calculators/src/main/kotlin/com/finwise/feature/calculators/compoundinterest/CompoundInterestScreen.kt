package com.finwise.feature.calculators.compoundinterest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finwise.core.ui.theme.FinWiseAppTheme

@Composable
internal fun CompoundInterestCalculatorScreen(welcomeText: String) {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
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
