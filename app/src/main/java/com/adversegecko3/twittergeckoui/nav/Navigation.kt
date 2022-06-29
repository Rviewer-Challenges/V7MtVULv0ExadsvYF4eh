package com.adversegecko3.twittergeckoui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adversegecko3.twittergeckoui.data.Screen
import com.adversegecko3.twittergeckoui.ui.screens.*

@Composable
fun SetupNavigation(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen()
        }

        composable(
            route = Screen.SearchScreen.route
        ) {
            SearchScreen()
        }

        composable(
            route = Screen.SpacesScreen.route
        ) {
            SpacesScreen()
        }

        composable(
            route = Screen.CommunitiesScreen.route
        ) {
            CommunitiesScreen()
        }

        composable(
            route = Screen.NotificationsScreen.route
        ) {
            NotificationsScreen()
        }

        composable(
            route = Screen.DirectMessagesScreen.route
        ) {
            DirectMessagesScreen()
        }
    }
}

