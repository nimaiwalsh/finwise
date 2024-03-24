package com.finwise.feature.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.finwise.core.ui.theme.FinWiseAppTheme

@Composable
fun SignupScreen(
    onBackClicked: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel(),
) {
    SignupScreen(onBackClicked = onBackClicked)
}

@Composable
fun SignupScreen(onBackClicked: () -> Unit) {
    FinWiseAppTheme {
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

                Text("SignupScreen")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_SignupScreen() {
    FinWiseAppTheme {
        SignupScreen(onBackClicked = {})
    }
}