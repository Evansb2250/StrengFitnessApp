package com.example.strengthfit.application

import android.content.Context
import com.example.strengthfit.database.StrengthFitDatabase
import com.example.strengthfit.repo.UserRepository
import com.example.strengthfit.repo.UserRepositoryImp

interface ApplicationContainer {
    val userRepository: UserRepository
}

class DefaultUserRepository(context: Context) : ApplicationContainer {

    override val userRepository: UserRepositoryImp by lazy {
        UserRepositoryImp(StrengthFitDatabase.getDatabase(context).UserDao())
    }
}