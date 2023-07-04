package com.example.strengthfit.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
    ){
        Text(text = "Hello World")
    }
}

@Composable
fun FavoriteScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
    ){
        Text(text = "Favorite Screen")
    }
}

@Composable
fun ExerciseScreen(
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
    ){
        Text(text = "Exercise Screen")
    }
}

@Composable
fun ProfileScreen(
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
    ){
        Text(text = "Profile Screen")
    }
}
