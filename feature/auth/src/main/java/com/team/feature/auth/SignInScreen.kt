package com.team.feature.auth

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
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SignInRoute(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel
) {
    val uiState by viewModel.loginUiState.collectAsStateWithLifecycle()

    SignInScreen(
        loginState = uiState,
        phone = "",
        onPhoneChange = {},
        password = "",
        onPasswordChange = {},
        onNavigationBack = { /*TODO*/ },
        onContinueClick = { /*TODO*/ })

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    loginState: AuthViewModel.UiState,
    phone: String,
    onPhoneChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onNavigationBack: () -> Unit,
    onContinueClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Scaffold(
        modifier = modifier,
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

            Text( // Title
                "Some text idk",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Text( // Paragraph
                "Some text idk asdljmaklsdanjsbdnnakjsndjasdnajd",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            OutlinedTextField( // Phone field
                value = phone,
                onValueChange = onPhoneChange,
                shape = RoundedCornerShape(8.dp),
                placeholder = {
                    Text(text = "Номер телефона или Email")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.padding(16.dp))

            OutlinedTextField( // Password field
                value = password,
                onValueChange = onPasswordChange,
                placeholder = {
                    Text(text = "Пароль")
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(12.dp),
                onClick = onContinueClick
            ) {
                Text(text = "SingIn")
            }
        }
    }
}

@Preview(name = "phone", device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480")
@Composable
fun PreviewLoginScreen() {
    BoxWithConstraints {
//        FMTheme {
//            SignInScreen(
//                loginState = LoginUiState.None,
//                phone = "",
//                onPhoneChange = {},
//                password = "",
//                onPasswordChange = {},
//                onNavigationBack = {},
//                onContinueClick = {}
//            )
//        }
    }
}

