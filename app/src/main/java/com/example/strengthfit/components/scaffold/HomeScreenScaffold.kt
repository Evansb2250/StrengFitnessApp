package com.example.strengthfit.components.scaffold

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.strengthfit.R
import com.example.strengthfit.components.bottomBar.BottomNavigationBar
import com.example.strengthfit.components.topBar.TopAppBarContent
import com.example.strengthfit.models.BottomNavItems
import com.example.strengthfit.navigation.HomeScreenNavigation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenScaffold(
    drawerState: DrawerState,
    scope: CoroutineScope,
    navController: NavHostController,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBarContent {
                scope.launch {
                    drawerState.open()
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(
                navItems = listOf(
                    BottomNavItems(
                        title = "Home",
                        route = "Home",
                        icon = R.drawable.home,
                    ),
                    BottomNavItems(
                        title = "Favorite",
                        route = "Favorite",
                        icon = R.drawable.favorite,
                    ),
                    BottomNavItems(
                        title = "Exercise",
                        route = "Exercise",
                        icon = R.drawable.exercise,
                    ),
                    BottomNavItems(
                        title = "Profile",
                        route = "Profile",
                        icon = R.drawable.profile,
                    )
                ),
                modifier = Modifier,
                navController = navController,
                onItemClicked = {
                    navController.navigate(it.route)
                }
            )
        },
        content = { padding ->
        }
    )
}
