package com.team.feature.auth

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.team.core.designsystem.theme.FMTheme

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun LoginRoute(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = hiltViewModel()
) {
    val uiState = viewModel.loginUiState.collectAsStateWithLifecycle()
}

@OptIn(ExperimentalLifecycleComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    loginState: LoginUiState,
    modifier: Modifier = Modifier
) {
    Scaffold() {
        TextField(
            value = "",
            onValueChange = {
            }
        )
    }
}

@Preview(name = "phone", device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480")
@Composable
fun PreviewLoginScreen() {
    BoxWithConstraints {
        FMTheme {
            LoginScreen(
                loginState = LoginUiState.None
            )
        }
    }
}

