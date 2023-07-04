package com.example.strengthfit.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.strengthfit.navigation.Routes.HomeScreen.homeScreen
import com.example.strengthfit.screens.LoginScreen
import com.example.strengthfit.screens.SignUpScreen

fun NavGraphBuilder.LoginNavigation(navController: NavController) {
    composable(
        route = Routes.Auth.loginScreen
    ) {
        LoginScreen(
            navigateToHomePage = {
                navController.navigate(homeScreen)
            },
            onSignUp = {
                navController.navigate(Routes.Auth.signupScreen)
            }
        )
    }

    composable(
        route = Routes.Auth.signupScreen
    ) {
        SignUpScreen {
            navController.navigate(Routes.Auth.loginScreen) {
                popUpTo(Routes.Auth.loginScreen) {
                    inclusive = true
                }
            }
        }
    }
}