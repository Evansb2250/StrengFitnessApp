package com.example.strengthfit.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.strengthfit.repo.UserRepository
import com.example.strengthfit.stateModels.LoginViewModelState
import com.example.strengthfit.stateModels.SignUpUIStates
import com.example.strengthfit.stateModels.SignUpUIStates.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpScreenViewModel(
    val userRepository: UserRepository,
    private val dispatcher: Dispatchers = Dispatchers
) : ViewModel() {

    private val _state: MutableStateFlow<SignUpUIStates> = MutableStateFlow(SignUpUIState())
    val state: StateFlow<SignUpUIStates> = _state.asStateFlow()

    fun updateFields(input: String, type: SignUpState) {
        if (_state.value is SignUpUIState) {
            _state.update {
                it as SignUpUIState
                it.copy(
                    name = if (type is SignUpState.Name) input else it.name,
                    email = if (type is SignUpState.Email) input else it.email,
                    password = if (type is SignUpState.Password) input else it.password
                )
            }
        }
    }

    fun signUp(data: SignUpUIState) {
        //update state to loading
        _state.value = Loading

        viewModelScope.launch(dispatcher.IO) {

            val result = userRepository.insertUser(
                userName = data.email,
                name = data.name,
                age = data.age,
                height = data.height,
                weight = data.weight,
                password = data.password,
            )
            when (result) {
                LoginViewModelState.UserState.UpdateStates.Failed -> _state.value = Failed
                LoginViewModelState.UserState.UpdateStates.Success -> _state.value =
                    Success(data.email)
            }
        }
    }

    fun onRetry() {
        _state.value = SignUpUIState()
    }
}


sealed class SignUpState {
    object Name : SignUpState()
    object Email : SignUpState()
    object Age : SignUpState()
    object Password : SignUpState()
    object Weight : SignUpState()
    object Height : SignUpState()
}