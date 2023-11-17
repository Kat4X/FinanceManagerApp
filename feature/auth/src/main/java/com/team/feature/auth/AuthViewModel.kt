package com.team.feature.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel : ViewModel() {
    data class UiState(
        val login: String = "",
        val password: String = "",
        val isLoginEnabled: Boolean = true
    )

    private val _loginUiState = MutableStateFlow(UiState())
    val loginUiState = _loginUiState.asStateFlow()
}