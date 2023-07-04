package com.example.strengthfit.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.strengthfit.application.AppViewModelProvider
import com.example.strengthfit.page.LoginScreenPage
import com.example.strengthfit.viewmodels.LoginScreenViewModel

@Composable
fun LoginScreen(
    vm: LoginScreenViewModel = viewModel(
        factory = AppViewModelProvider.Factory,
    ),
    navigateToHomePage:  (String) -> Unit = {},
    onSignUp: () -> Unit = {},
) {
    LoginScreenPage(
        state = vm.state.collectAsState().value,
        onEmailChange = { email ->
            vm.updateEmail(email)
        },
        onPasswordChange = { password ->
            vm.updatePassword(password)
        },
        onSignUp = onSignUp,
        onSubmit = { email, password ->
            vm.requestAccess(email, password)
        },
        onNavigateToHomePage = navigateToHomePage,
        onDismissError = {vm.resetState()}
    )
}


