package com.example.strengthfit.components.navigationDrawer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.strengthfit.components.DrawerSheetContent.DrawerSheetContent
import com.example.strengthfit.components.scaffold.HomeScreenScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenDrawer(
    userId: String,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        val navHostController: NavHostController = rememberNavController()
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = { DrawerSheetContent() },
            content = {
                HomeScreenScaffold(
                    drawerState = drawerState,
                    scope = scope,
                    navController = navHostController
                )
            }
        )
    }
}
