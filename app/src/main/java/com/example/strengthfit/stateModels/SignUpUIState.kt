package com.example.strengthfit.stateModels

sealed class SignUpUIStates {
    data class SignUpUIState(
        val email: String = "",
        val name: String = "",
        val age: Int = 0,
        val password: String = "",
        val height: Double = 0.0,
        val weight: Double = 0.0,
    ): SignUpUIStates(){
        fun hasValidEmail():Boolean = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        fun hasValidPassword(): Boolean = password.length > 6
        fun ageHasError(): Boolean = true
        fun heightHasError(): Boolean = true
        fun weightHasError(): Boolean = true

    }

    data class Success(val email: String) : SignUpUIStates()
    object Failed : SignUpUIStates()
    object Loading : SignUpUIStates()

}

