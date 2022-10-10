package com.team.feature.auth.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.team.core.navigation.FMNavigationDestination
import com.team.feature.auth.AuthViewModel
import com.team.feature.auth.SignInRoute

object AuthDestination : FMNavigationDestination {
    override val route = "auth_route"
    override val destination = "auth_destination"
}

fun NavGraphBuilder.authGraph() {
    composable(route = AuthDestination.route) {
        val viewModel: AuthViewModel = hiltViewModel()
        SignInRoute(
            modifier = Modifier.fillMaxSize(),
            viewModel = viewModel
        )
    }
}