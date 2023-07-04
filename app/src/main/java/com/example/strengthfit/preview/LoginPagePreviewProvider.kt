package com.example.strengthfit.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.strengthfit.stateModels.LoginViewModelState

class LoginPagePreviewProvider: PreviewParameterProvider<LoginViewModelState.LoginState> {
    override val values: Sequence<LoginViewModelState.LoginState>
        get() = sequence {
            LoginViewModelState.LoginState.LoginUiState(
                "dadsad",
                "dasda",
                false,
            )
        }
}