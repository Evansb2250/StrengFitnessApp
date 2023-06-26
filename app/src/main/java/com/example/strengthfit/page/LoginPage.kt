package com.example.strengthfit.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.strengthfit.components.CustomOutLineButton
import com.example.strengthfit.preview.LoginPagePreviewProvider
import com.example.strengthfit.stateModels.LoginViewModelState

@Preview()
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenPage(
    @PreviewParameter(LoginPagePreviewProvider::class, limit = 1)
    loginUiState: LoginViewModelState.LoginUiState,
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onSignUp: () -> Unit = {},
    onSubmit: () -> Unit = {},
) {
    Column {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = loginUiState.email,
            label = {
                Text(text = "Email")
            },
            onValueChange = onEmailChange,

            )
        Spacer(modifier = Modifier.size(25.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = loginUiState.password,
            label = {
                Text(text = "Password")
            },
            onValueChange = onPasswordChange,
        )

        Spacer(modifier = Modifier.size(50.dp))

        CustomOutLineButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 50.dp,
                ),
            onClick = onSubmit,
            buttonText = "Login"
        )

        CustomOutLineButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 50.dp,
                ),
            onClick = onSignUp,
            buttonText = "Sign up"
        )
    }
}