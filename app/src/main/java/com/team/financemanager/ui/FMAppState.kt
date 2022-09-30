package com.team.financemanager.ui

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.tracing.trace
import com.team.core.designsystem.icon.AppIcon
import com.team.core.designsystem.icon.Icon
import com.team.core.navigation.FMNavigationDestination
import com.team.feature.auth.navigation.AuthDestination
import com.team.financemanager.navigation.TopLevelDestination
import com.team.feature.auth.R as authR

@Composable
fun rememberFMAppState(
    windowSizeClass: WindowSizeClass,
    navController: NavHostController = rememberNavController()
): FMAppState {
    return remember(navController, windowSizeClass) {
        FMAppState(navController, windowSizeClass)
    }
}

@Stable
class FMAppState(
    val navController: NavHostController,
    val windowSizeClass: WindowSizeClass
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact ||
                windowSizeClass.heightSizeClass == WindowHeightSizeClass.Expanded

    val topLevelDestinations: List<TopLevelDestination> = listOf(
        TopLevelDestination(
            route = AuthDestination.route,
            destination = AuthDestination.destination,
            selectedIcon = Icon.ImageVectorIcon(AppIcon.Add),
            unselectedIcon = Icon.ImageVectorIcon(AppIcon.VolumeUp),
            iconTextId = authR.string.auth
        )
    )

    /**
     * UI logic for navigating to a particular destination in the app. The NavigationOptions to
     * navigate with are based on the type of destination, which could be a top level destination or
     * just a regular destination.
     *
     * Top level destinations have only one copy of the destination of the back stack, and save and
     * restore state whenever you navigate to and from it.
     * Regular destinations can have multiple copies in the back stack and state isn't saved nor
     * restored.
     *
     * @param destination: The [NiaNavigationDestination] the app needs to navigate to.
     * @param route: Optional route to navigate to in case the destination contains arguments.
     */
    fun navigate(destination: FMNavigationDestination, route: String? = null) {
        trace("Navigation $destination") {
            if (destination is TopLevelDestination) {
                navController.navigate(route ?: destination.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            } else {
                navController.navigate(route ?: destination.route)
            }
        }
    }

    fun onBackPressed() {
        navController.popBackStack()
    }
}

/**
 * Stores information about navigation events to be used with JankStats
 */
/*
@Composable
private fun NavigationTrackingSideEffect() {
    Jank

}*/
