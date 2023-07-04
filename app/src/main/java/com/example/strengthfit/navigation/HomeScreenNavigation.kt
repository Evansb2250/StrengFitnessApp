package com.example.strengthfit.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.strengthfit.screens.ExerciseScreen
import com.example.strengthfit.screens.FavoriteScreen
import com.example.strengthfit.screens.HomeScreen
import com.example.strengthfit.screens.ProfileScreen


fun NavGraphBuilder.HomeScreenNavigation(navController: NavHostController,){
    composable(
        route = "Home"
    ) {
        HomeScreen( )
    }

    composable(
        route = "Favorite"
    ) {
        FavoriteScreen()
    }

    composable(
        route = "Exercise"
    ) {
        ExerciseScreen()
    }

    composable(
        route = "Profile"
    ) {
        ProfileScreen()
    }
}
