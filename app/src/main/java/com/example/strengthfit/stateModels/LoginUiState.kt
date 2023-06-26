package com.example.strengthfit.stateModels


sealed class LoginViewModelState {

    data class LoginUiState(
        val email: String,
        val password: String,
        val showPassword: Boolean,
    ) : LoginViewModelState()


    sealed class UserState {
        object UserExist : UserState()
        object UserDoesntExist : UserState()

        sealed class UpdateStates : UserState() {
            object Success : UpdateStates()
            object Failed : UpdateStates()
        }
    }

    sealed class LoginState {

        data class ErrorUiState(val error: Throwable) : LoginState()
        data class SuccessLoginUIState(
            val email: String,
        ) : LoginState()
    }

    data class Error(val message: String) : UserState()
}
