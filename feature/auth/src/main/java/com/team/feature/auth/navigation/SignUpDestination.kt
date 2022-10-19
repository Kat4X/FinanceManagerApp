package com.team.feature.auth.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.team.core.navigation.FMNavigationDestination
import com.team.feature.auth.sign_up.SignUpRoute
import com.team.feature.auth.sign_up.SignUpViewModel

object SignUpDestination : FMNavigationDestination {
    override val route: String = "sign_up_route"

    override val destination: String = "sign_up_destination"
}

fun NavGraphBuilder.signUpGraph(
    navController: NavHostController
) {

    composable(route = SignUpDestination.route) {
        val viewModel: SignUpViewModel = hiltViewModel()
        SignUpRoute(viewModel = viewModel, navController = navController)
    }

}