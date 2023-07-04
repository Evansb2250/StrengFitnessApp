package com.example.strengthfit.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.strengthfit.repo.UserRepository
import com.example.strengthfit.stateModels.LoginViewModelState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginScreenViewModel(
    val userRepository: UserRepository,
    private val dispatcher: Dispatchers = Dispatchers
) : ViewModel() {
    private val _state: MutableStateFlow<LoginViewModelState.LoginState> = MutableStateFlow(
        LoginViewModelState.LoginState.LoginUiState(
            "",
            "",
            false,
        )
    )
    val state: StateFlow<LoginViewModelState.LoginState> = _state

    fun updateEmail(email: String) {
        val currentState = _state.value
        if (currentState is LoginViewModelState.LoginState.LoginUiState) {
            _state.value = currentState.updateEmail(email)
        }
    }

    fun updatePassword(password: String) {
        val currentState = _state.value
        if (currentState is LoginViewModelState.LoginState.LoginUiState) {
            _state.value = currentState.updatePassword(password)
        }
    }

    fun requestAccess(
        userName: String,
        password: String,
    ) {
        viewModelScope.launch(dispatcher.IO) {
            val result = userRepository.getUser(
                userName,
                password
            )

            if (result != null) {
                _state.value = LoginViewModelState.LoginState.SuccessLoginUIState(result.email)

            } else {
                _state.value = LoginViewModelState.LoginState.ErrorUiState(FailedLoging)
            }
        }


    }

    fun submit(
        email: String,
        password: String,
    ) {
        val result = viewModelScope.async(dispatcher.IO) {
            userRepository.getUser(
                email,
                password,
            )
        }.onAwait

    }

    fun resetState() {
        _state.value = LoginViewModelState.LoginState.LoginUiState(
            "",
            "",
            false,
        )
    }
}


object FailedLoging : Throwable()
object IncorrectPath : Throwable()