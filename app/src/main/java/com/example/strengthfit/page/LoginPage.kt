package com.example.strengthfit.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.strengthfit.components.CustomOutLineButton
import com.example.strengthfit.preview.LoginPagePreviewProvider
import com.example.strengthfit.stateModels.LoginViewModelState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenPage(
    @PreviewParameter(LoginPagePreviewProvider::class, limit = 1)
    state: LoginViewModelState.LoginState,
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onSignUp: () -> Unit = {},
    onSubmit: (email: String, password: String) -> Unit = { _, _ -> },
    onNavigateToHomePage: (@Composable (String) -> Unit) -> Unit,
) {
    when (state) {
        is LoginViewModelState.LoginState.ErrorUiState -> TODO()
        is LoginViewModelState.LoginState.SuccessLoginUIState -> TODO()
        is LoginViewModelState.LoginState.LoginUiState -> {
            Column {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.email,
                    label = {
                        Text(text = "Email")
                    },
                    onValueChange = onEmailChange,

                    )
                Spacer(modifier = Modifier.size(25.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.password,
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
                    onClick = {
                        onSubmit(state.email, state.password)
                    },
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
    }
}
