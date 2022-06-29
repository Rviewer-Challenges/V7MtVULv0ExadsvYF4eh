package com.adversegecko3.twittergeckoui.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.adversegecko3.twittergeckoui.R
import com.adversegecko3.twittergeckoui.data.Screen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        //topBar = { TopBar() },
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            SetupNavigation(navHostController = navController)
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(text = "Hola")
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.profile_adversegecko3),
                    contentDescription = "User Profile Photo",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .clip(CircleShape)
                )
            }
        },
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 0.dp,
        modifier = Modifier.height(52.dp)
    )
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        Screen.HomeScreen,
        Screen.SearchScreen,
        Screen.SpacesScreen,
        Screen.CommunitiesScreen,
        Screen.NotificationsScreen,
        Screen.DirectMessagesScreen,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Column(Modifier.fillMaxWidth()) {
        Divider()
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.surface,
            elevation = 0.dp
        ) {
            screens.forEach { screen ->
                NavBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.NavBarItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true
    BottomNavigationItem(
        icon = {
            Icon(
                painter = if (selected) {
                    painterResource(screen.selectedIcon)
                } else {
                    painterResource(screen.unselectedIcon)
                },
                contentDescription = "NavBar ${screen.title} Icon"
            )
        },
        selected = selected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        alwaysShowLabel = false
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}