package com.team.financemanager.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.team.core.navigation.FMNavigationDestination
import com.team.feature.auth.navigation.AuthDestination
import com.team.feature.auth.navigation.SignUpDestination
import com.team.feature.auth.navigation.SignUpPinDestination
import com.team.feature.auth.navigation.authGraph
import com.team.feature.auth.navigation.signUpGraph
import com.team.feature.auth.navigation.signUpPinGraph

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
        composable(route = startDestination) {
            authGraph()
        }
        composable(route = SignUpDestination.route){
            signUpGraph(navController)
        }
        composable(route = SignUpPinDestination.route){
            signUpPinGraph(navController)
        }
    }

}