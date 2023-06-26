package com.example.strengthfit.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey()
    val email:String,
    val name:String,
    val age:Int,
    val password:String,
    val height: Double,
    val weight:Double,
)
