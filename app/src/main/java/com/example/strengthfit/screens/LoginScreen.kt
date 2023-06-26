package com.example.strengthfit.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.strengthfit.application.AppViewModelProvider
import com.example.strengthfit.page.LoginScreenPage
import com.example.strengthfit.viewmodels.LoginScreenViewModel

@Composable
fun LoginScreen(
    vm: LoginScreenViewModel = viewModel(
        factory = AppViewModelProvider.Factory,
    ),
    navigateToHomePage: (@Composable (String) -> Unit) = {},
    onSignUp: () -> Unit = {},
) {
    LoginScreenPage(
        loginUiState = vm.state.collectAsState().value,
        onEmailChange = { email ->
            vm.updateEmail(email)
        },
        onPasswordChange = { password ->
            vm.updatePassword(password)
        },
        onSignUp = onSignUp,
        onSubmit = { vm.submit() }
    )
}
