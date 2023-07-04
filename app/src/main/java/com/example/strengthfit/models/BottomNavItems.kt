package com.example.strengthfit.models

import androidx.annotation.DrawableRes

data class BottomNavItems(
    val title: String,
    val route: String,
    @DrawableRes val icon: Int,
)