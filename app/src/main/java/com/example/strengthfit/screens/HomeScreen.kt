package com.example.strengthfit.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun HomeScreen(
    paddingValues: PaddingValues
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(paddingValues),
    ){
        Text(text = "Hello World")
    }
}

@Composable
fun FavoriteScreen(
    paddingValues: PaddingValues
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(paddingValues),
    ){
        Text(text = "Favorite Screen")
    }
}

@Composable
fun ExerciseScreen(
    paddingValues: PaddingValues
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(paddingValues),
    ){
        Text(text = "Exercise Screen")
    }
}

@Composable
fun ProfileScreen(
    paddingValues: PaddingValues
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(paddingValues),
    ){
        Text(text = "Profile Screen")
    }
}
