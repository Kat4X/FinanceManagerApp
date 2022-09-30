package com.team.financemanager.navigation

import androidx.annotation.Keep
import com.team.core.designsystem.icon.Icon
import com.team.core.navigation.FMNavigationDestination

/**
 * Type for the top level destinations in the application. Each of these destinations
 * can contain one or more screens (based on the window size). Navigation from one screen to the
 * next within a single destination will be handled directly in composables.
 */
@Keep
data class TopLevelDestination(
    override val route: String,
    override val destination: String,
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int
): FMNavigationDestination