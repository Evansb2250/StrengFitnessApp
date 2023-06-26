package com.example.strengthfit.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.strengthfit.database.models.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insertUser(user: User)

    @Query("SELECT * FROM User WHERE email = :userName AND password = :password")
    fun getUser(
        userName: String,
        password: String
    ): User?

    @Query("Select * FROM user where email =:userName")
    suspend fun getUser(
        userName: String,
    ): User?

    @Delete
    suspend fun deleteUser(user: User)
}
