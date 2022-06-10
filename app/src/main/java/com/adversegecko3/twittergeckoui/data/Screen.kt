package com.adversegecko3.twittergeckoui.data

import com.adversegecko3.twittergeckoui.R

sealed class Screen(
    val route: String,
    val title: String,
    val selectedIcon: Int,
    val unselectedIcon: Int
) {
    object HomeScreen : Screen(
        route = "HomeScreen",
        title = "Home",
        selectedIcon = R.drawable.ic_nav_home_selected,
        unselectedIcon = R.drawable.ic_nav_home_unselected,
    )

    object SearchScreen : Screen(
        route = "SearchScreen",
        title = "Home",
        selectedIcon = R.drawable.ic_nav_search_selected,
        unselectedIcon = R.drawable.ic_nav_search_unselected,
    )

    object SpacesScreen : Screen(
        route = "SpacesScreen",
        title = "Home",
        selectedIcon = R.drawable.ic_nav_spaces_selected,
        unselectedIcon = R.drawable.ic_nav_spaces_unselected,
    )

    object CommunitiesScreen : Screen(
        route = "CommunitiesScreen",
        title = "Home",
        selectedIcon = R.drawable.ic_nav_communities_selected,
        unselectedIcon = R.drawable.ic_nav_communities_unselected,
    )

    object NotificationsScreen : Screen(
        route = "NotificationsScreen",
        title = "Home",
        selectedIcon = R.drawable.ic_nav_notifications_selected,
        unselectedIcon = R.drawable.ic_nav_notifications_unselected,
    )

    object DirectMessagesScreen : Screen(
        route = "DirectMessagesScreen",
        title = "Home",
        selectedIcon = R.drawable.ic_nav_directmessages_selected,
        unselectedIcon = R.drawable.ic_nav_directmessages_unselected,
    )
}
