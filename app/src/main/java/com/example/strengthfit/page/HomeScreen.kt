package com.example.strengthfit.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.strengthfit.pixels.dp16

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(dp16),
        topBar = { TopAppBarContent() },
        bottomBar = {},
        content = { it -> ScaffoldContent(it)}
    )
}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarContent(){
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {

                }
            ) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Drawer Icon")
            }
        },
        title = {
            Text(
                text = "StrengthFit",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        },
        actions = {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(color = Color.Gray)
            )
        }
    )
}

@Composable
fun ScaffoldContent(paddingValues: PaddingValues) {
    Text(text = "Hello",
        modifier = Modifier.padding(paddingValues)
        )
}