package com.team.feature.auth.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.team.core.navigation.FMNavigationDestination
import com.team.feature.auth.signup_pin.SignUpPinRoute
import com.team.feature.auth.signup_pin.SignUpPinViewModel

object SignUpPinDestination : FMNavigationDestination {
    override val route: String = "sign_up_pin_route"
    override val destination: String = "sign_up_pin_destination"
}

fun NavGraphBuilder.signUpPinGraph(
    navController: NavHostController
) {
    composable(route = SignUpPinDestination.route) {
        val viewModel: SignUpPinViewModel = hiltViewModel()
        SignUpPinRoute(viewModel = viewModel, navController = navController)
    }
}