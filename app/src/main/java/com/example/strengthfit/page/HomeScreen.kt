package com.example.strengthfit.page

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen() {
    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {
            Text("Drawer title", modifier = Modifier.padding(16.dp))
            Divider()
            NavigationDrawerItem(
                label = { Text(text = "Drawer Item") },
                selected = false,
                onClick = {  }
            )
        }
    }) {

    }



    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        topBar = {

        },
        bottomBar = {
        }
    ) {
        Text(text = "Hello")
    }
}