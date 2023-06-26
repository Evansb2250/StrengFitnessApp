package com.example.strengthfit.page

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.strengthfit.components.CustomOutLineButton
import com.example.strengthfit.components.dialogue.FailureDialog
import com.example.strengthfit.components.dialogue.SuccessDialog
import com.example.strengthfit.components.textfield.GenericTextField
import com.example.strengthfit.components.textfield.PasswordOutLineTextField
import com.example.strengthfit.stateModels.SignUpUIStates
import com.example.strengthfit.stateModels.SignUpUIStates.*
import com.example.strengthfit.viewmodels.SignUpState

@OptIn(ExperimentalComposeUiApi::class)
@Preview(
    showBackground = true
)
@Composable
fun SignUpPage(
    @PreviewParameter(SignUpStatePreviewProvider::class)
    state: SignUpUIStates,
    onUpdateFieldError: (String, SignUpState) -> Unit = { _, _ -> },
    navigateToHomePage: (String) -> Unit = {},
    onSignUp: (SignUpUIState) -> Unit = {},
    onDismiss: () -> Unit = {},
    onRetry: () -> Unit = {},
) {
    when (state) {
        Failed -> {
            //If user couldn't log in
            FailureDialog(
                onCancel = onDismiss,
                onRetry = onRetry,
            )
        }

        is Success -> {
            //If user could login navigate to LoginScreen
            SuccessDialog(
                onDismiss = onDismiss,
            )
            navigateToHomePage(state.email)
        }

        is SignUpUIState -> {
            // Handle the SignUpUIState

            // Focus Manager for the Column Row
            val focusManager = LocalFocusManager.current
            Column(
                modifier = Modifier
                    .clickable(
                        onClick = {
                            focusManager.clearFocus()
                        }
                    )
            ) {

                Spacer(
                    modifier = Modifier
                        .size(
                            size = 50.dp,
                        )
                )

                GenericTextField(
                    value = state.name,
                    onValueChange = { name ->
                        onUpdateFieldError(name, SignUpState.Name)
                    },
                    labelText = "Name",
                    isError = state.name.isEmpty(),
                    errorMessage = "Most have a valid name"
                )

                GenericTextField(
                    value = state.email,
                    onValueChange = { email ->
                        onUpdateFieldError(email, SignUpState.Email)
                    },
                    labelText = "Email",
                    isError = !state.hasValidEmail(),
                    errorMessage = "must have a valid email address"
                )

                PasswordOutLineTextField(
                    value = state.password,
                    onValueChange = { password ->
                        onUpdateFieldError(password, SignUpState.Password)
                    },
                    labelText = "Password",
                    isError = !state.hasValidPassword()
                )

                Spacer(
                    modifier = Modifier
                        .size(
                            size = 200.dp,
                        )
                )
                CustomOutLineButton(
                    onClick = { onSignUp(state) },
                    buttonText = "Sign Up",
                    enable = state.hasValidEmail() && state.name.isNotEmpty() && state.hasValidPassword()
                )

                CustomOutLineButton(
                    onClick = onDismiss,
                    buttonText = "Cancel"
                )
            }
        }

        else -> {
            //TODO(do nothing)
        }
    }

}
