package com.team.feature.auth.sign_up

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.team.core.designsystem.theme.FMTheme
import com.team.feature.auth.navigation.SignUpPinDestination

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun SignUpRoute(
    viewModel: SignUpViewModel,
    navController: NavHostController
) {
    val uiState by viewModel.signUpState.collectAsStateWithLifecycle(initialValue = SignUpUiState.None)

    SignUpScreen(
        loginState = uiState,
        email = viewModel.emailField,
        onEmailChange = {},
        password = viewModel.passwordField,
        onPasswordChange = {},
        onNavigationBack = { navController.previousBackStackEntry },
        onContinueClick = { navController.navigate(SignUpPinDestination.route)})

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    loginState: SignUpUiState,
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onNavigationBack: () -> Unit,
    onContinueClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = Modifier.padding(10.dp),
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onNavigationBack) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBackIosNew,
                            contentDescription = "Button to navigate back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(// Title
                text = "SignUp",
                modifier = Modifier.padding(horizontal = 18.dp),
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.padding(18.dp))
            OutlinedTextField(//Email
                value = email,
                onValueChange = onEmailChange,
                placeholder = {
                    Text(text = "Email")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.padding(18.dp))
            OutlinedTextField(//Password
                value = password,
                onValueChange = onPasswordChange,
                placeholder = {
                    Text(text = "Password")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.padding(18.dp))
            Button(
                onClick = onContinueClick,
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(text = "SignUp")
            }
            Spacer(modifier = Modifier.padding(18.dp))
            Button(
                onClick = {  },
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Skip")
            }
        }

    }
}

@Preview(name = "phone", device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480")
@Composable
fun PreviewLoginScreen() {
    BoxWithConstraints {
        FMTheme {
            SignUpScreen(
                loginState = SignUpUiState.None,
                email = "",
                onEmailChange = {},
                password = "",
                onPasswordChange = {},
                onNavigationBack = {},
                onContinueClick = {}
            )
        }
    }
}
