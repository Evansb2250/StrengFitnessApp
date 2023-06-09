package com.example.strengthfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.strengthfit.components.topBar.SFTopBar
import com.example.strengthfit.constants.appTitle
import com.example.strengthfit.page.ExerciseScreen
import com.example.strengthfit.page.FavoriteScreen
import com.example.strengthfit.page.HomeScreen
import com.example.strengthfit.page.ProfileScreen
import com.example.strengthfit.ui.theme.StrengthFitTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StrengthFitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val scope = rememberCoroutineScope()
                    val navHostController = rememberNavController()
                    ModalNavigationDrawer(
                        drawerState = drawerState,
                        drawerContent = { DrawerSheetContent() },
                        content = {
                            SFScaffold(
                                drawerState = drawerState,
                                scope = scope,
                                navController = navHostController
                            )
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun ProfileImage(

) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(
                color = Color.Transparent,
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            modifier = Modifier,
            shape = CircleShape,
            content = {
                Image(
                    painter = painterResource(
                        R.drawable.profile_image,
                    ),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarContent(
    openDrawer: () -> Unit,
) {
    SFTopBar(
        title = {
            Text(
                text = appTitle,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    openDrawer()
                }
            ) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Drawer Icon")
            }
        },
        actions = {
            ProfileImage()
        }
    )
}

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SFScaffold(
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
            Navigation(
                navController = navController,
                paddingValues = padding,
            )
        }
    )
}

@Composable
fun Navigation(
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {
        composable(
            route = "Home"
        ) {
            HomeScreen(paddingValues = paddingValues)
        }

        composable(
            route = "Favorite"
        ){
            FavoriteScreen(paddingValues = paddingValues)
        }

        composable(
            route = "Exercise"
        ){
            ExerciseScreen(paddingValues = paddingValues)
        }

        composable(
            route = "Profile"
        ){
            ProfileScreen(paddingValues = paddingValues)
        }
    }
}

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


data class BottomNavItems(
    val title: String,
    val route: String,
    @DrawableRes val icon: Int,
)


private val BottomNavigationHeight = 56.dp

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