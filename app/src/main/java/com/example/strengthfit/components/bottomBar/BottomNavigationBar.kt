package com.example.strengthfit.components.bottomBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.strengthfit.models.BottomNavItems

private val BottomNavigationHeight = 56.dp


@Composable
fun BottomNavigationBar(
    navItems: List<BottomNavItems>,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onItemClicked: (BottomNavItems) -> Unit,
) {
    val backStack = navController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = modifier,
    ) {
        navItems.forEach {
            val isSelected = it.route == backStack.value?.id
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemClicked(it) },
                icon = {
                    Image(
                        painter = painterResource(id = it.icon),
                        contentDescription = it.route,
                    )
                }
            )
        }
    }
}



@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.contentColorFor(backgroundColor),
    elevation: Dp = 20.dp,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        tonalElevation = elevation,
        modifier = modifier
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(BottomNavigationHeight)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
            content = content
        )
    }
}