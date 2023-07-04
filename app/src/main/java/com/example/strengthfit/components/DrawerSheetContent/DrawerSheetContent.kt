package com.example.strengthfit.components.DrawerSheetContent

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerSheetContent() {
    ModalDrawerSheet(
        modifier = Modifier.width(200.dp)
    ) {
        Text(
            "Drawer title",
            modifier = Modifier.padding(16.dp),
        )
        Divider()
        NavigationDrawerItem(
            label = { Text(text = "Profile") },
            selected = false,
            onClick = { }
        )
        NavigationDrawerItem(
            label = { Text(text = "Settings") },
            selected = false,
            onClick = { }
        )
    }
}