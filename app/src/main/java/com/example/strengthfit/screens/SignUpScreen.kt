package com.example.strengthfit.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.strengthfit.application.AppViewModelProvider
import com.example.strengthfit.page.SignUpPage
import com.example.strengthfit.viewmodels.SignUpScreenViewModel

@Composable
fun SignUpScreen(
    viewModel: SignUpScreenViewModel = viewModel(factory = AppViewModelProvider.Factory),
    onDismiss: () -> Unit = {},
) {
    SignUpPage(
        state = viewModel.state.collectAsState().value,
        onUpdateFieldError = viewModel::updateFields,
        onSignUp = viewModel::signUp,
        onDismiss = onDismiss,
        onRetry = {viewModel.onRetry()}
    )
}