package com.example.strengthfit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.strengthfit.navigation.Routes.Auth.loginScreen
import com.example.strengthfit.navigation.Routes.Auth.signupScreen
import com.example.strengthfit.navigation.Routes.HomeScreen.homeScreen
import com.example.strengthfit.screens.LoginScreen
import com.example.strengthfit.screens.SignUpScreen

@Composable
fun RootNavigation(
) {
    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = Routes.Auth.auth
    ) {
        navigation(
            startDestination = Routes.Auth.loginScreen,
            route = Routes.Auth.auth,
        ) {
            this.LoginNavigation(navHostController)
        }

        navigation(
            startDestination = "Home",
            route = homeScreen
        ){
            this.HomeScreenNavigation(navHostController)
        }
    }
}




object Routes {
    object Auth {
        const val auth = "auth"
        const val splashScreen = ""
        const val loginScreen = "loginScreen"
        const val signupScreen = "signupScreen"
    }

    object HomeScreen {
        const val homeScreen = "homeScreen"
    }
}