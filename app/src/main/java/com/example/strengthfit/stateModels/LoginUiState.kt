package com.example.strengthfit.stateModels


sealed class LoginViewModelState {
    sealed class UserState {
        object UserExist : UserState()
        object UserDoesntExist : UserState()

        sealed class UpdateStates : UserState() {
            object Success : UpdateStates()
            object Failed : UpdateStates()
        }
    }

    sealed class LoginState {

        data class LoginUiState(
            val email: String,
            val password: String,
            val showPassword: Boolean,
        ) : LoginState() {
            fun updateEmail(newEmail: String) = copy(
                email = newEmail
            )

            fun updatePassword(newPassword: String) = copy(
                password = newPassword,
            )
        }

        data class ErrorUiState(val error: Throwable) : LoginState()
        data class SuccessLoginUIState(
            val email: String,
        ) : LoginState()

        sealed class Loading : LoginViewModelState()
    }

    data class Error(val message: String) : UserState()
}
