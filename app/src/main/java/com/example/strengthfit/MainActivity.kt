package com.example.strengthfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.strengthfit.navigation.RootNavigation
import com.example.strengthfit.screens.ExerciseScreen
import com.example.strengthfit.screens.FavoriteScreen
import com.example.strengthfit.screens.HomeScreen
import com.example.strengthfit.screens.ProfileScreen
import com.example.strengthfit.ui.theme.StrengthFitTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StrengthFitTheme {
                Surface() {
                    RootNavigation()
                }
            }
        }
    }
}