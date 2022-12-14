package com.team.financemanager.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.team.core.navigation.FMNavigationDestination
import com.team.feature.auth.navigation.AuthDestination
import com.team.feature.auth.navigation.authGraph

@Composable
fun FMNavHost(
    navController: NavHostController,
    onNavigateToDestination: (FMNavigationDestination, String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = AuthDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        authGraph()
    }

}