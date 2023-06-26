package com.example.strengthfit.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.strengthfit.stateModels.LoginViewModelState

class LoginPagePreviewProvider: PreviewParameterProvider<LoginViewModelState.LoginUiState> {
    override val values: Sequence<LoginViewModelState.LoginUiState>
        get() = sequence {
            LoginViewModelState.LoginUiState(
                "dadsad",
                "dasda",
                false,
            )
        }
}