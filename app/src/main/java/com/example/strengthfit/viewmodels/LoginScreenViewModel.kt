package com.example.strengthfit.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.strengthfit.repo.UserRepository
import com.example.strengthfit.stateModels.LoginViewModelState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginScreenViewModel(
    val userRepository: UserRepository,
    private val dispatcher: Dispatchers = Dispatchers
) : ViewModel() {
    private val _state : MutableStateFlow<LoginViewModelState.LoginUiState> = MutableStateFlow(
        LoginViewModelState.LoginUiState(
            "",
            "",
            false,
        )
    )
    val state: StateFlow<LoginViewModelState.LoginUiState> = _state

    fun updateEmail(email: String) {
         _state.update {
            it.copy(
                email = email
            )
        }
    }

    fun updatePassword(password: String){
        _state.update {
            it.copy(
                password = password
            )
        }
    }

    fun requestAccess(
        userName: String,
        password: String,
    ) {
        val results = viewModelScope.async {
            userRepository.getUser(
                userName,
                password
            )
        }
    }

    fun submit() {
      val result =  viewModelScope.async(dispatcher.IO) {
            userRepository.getUser(
                state.value.email,
                state.value.password
            )
        }.onAwait

    }
}