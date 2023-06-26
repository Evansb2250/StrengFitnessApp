package com.example.strengthfit.repo

import com.example.strengthfit.database.models.User
import com.example.strengthfit.DAO.UserDao
import com.example.strengthfit.stateModels.LoginViewModelState.UserState


interface UserRepository {
    suspend fun getUser(
        userName: String,
        password: String,
    ): User?

    suspend fun insertUser(
        userName: String,
        name: String,
        age: Int,
        height: Double,
        weight: Double,
        password: String,
    ): UserState.UpdateStates

    suspend fun deleteUser(
        userName: User,
    ): UserState.UpdateStates

    suspend fun updateUser(
        user: User,
    ): UserState.UpdateStates
}


class UserRepositoryImp(
    val userDao: UserDao,
) : UserRepository {

    override suspend fun getUser(
        userName: String,
        password: String,
    ): User? {
        return userDao.getUser(
            userName = userName,
            password = password,
        )
    }

    private suspend fun userExist(
        userName: String,
    ): UserState {
        val result = userDao.getUser(
            userName = userName,
        )
        return when (result) {
            null ->  UserState.UserDoesntExist
            else -> UserState.UserExist
        }
    }

    override suspend fun insertUser(
        userName: String,
        name: String,
        age: Int,
        height: Double,
        weight: Double,
        password: String,
    ): UserState.UpdateStates {
        return when (userExist(userName)) {
            is UserState.UserDoesntExist -> {
                userDao.insertUser(
                    User(
                        email = userName,
                        name = name,
                        age = age,
                        height = height,
                        weight = weight,
                        password = password,
                    )
                )
                UserState.UpdateStates.Success
            }
            else -> UserState.UpdateStates.Failed
        }
    }

    override suspend fun deleteUser(user: User): UserState.UpdateStates {
        return when (userExist(user.name)) {
            UserState.UserExist -> {
                userDao.deleteUser(user)
                UserState.UpdateStates.Success
            }
            else -> UserState.UpdateStates.Failed
        }
    }

    override suspend fun updateUser(user: User): UserState.UpdateStates {
        lateinit var result: UserState.UpdateStates
        try {
            userDao.insertUser(user)
            result = UserState.UpdateStates.Success
        } catch (e: Exception) {
            result = UserState.UpdateStates.Failed
        }

        return result
    }
}


object NoUserFound : Throwable("no UserFound")
object FailedUserUpdate: Throwable("FailedUserUpdate")