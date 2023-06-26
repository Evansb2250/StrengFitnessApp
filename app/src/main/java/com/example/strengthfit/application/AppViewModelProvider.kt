package com.example.strengthfit.application

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.strengthfit.viewmodels.LoginScreenViewModel
import com.example.strengthfit.viewmodels.SignUpScreenViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            LoginScreenViewModel(this.application().container.userRepository)
        }

        initializer {
            SignUpScreenViewModel(
                this.application().container.userRepository
            )
        }
    }
}

fun CreationExtras.application(): StrengthFit = (this[APPLICATION_KEY] as StrengthFit)
