package com.example.strengthfit.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.strengthfit.DAO.UserDao
import com.example.strengthfit.database.models.User


@Database(
    entities = [User::class],
    version = 1
)
abstract class StrengthFitDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: StrengthFitDatabase? = null

        fun getDatabase(context: Context): StrengthFitDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context = context,
                    StrengthFitDatabase::class.java,
                    "StrengthFit_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}