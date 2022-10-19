package com.team.feature.auth.signup_pin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


sealed interface SignUpPinUiState{
    object None: SignUpPinUiState
}

@OptIn(SavedStateHandleSaveableApi::class)
@HiltViewModel
class SignUpPinViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    var pinField by mutableStateOf("")
        private set
    val signUpPinState: Flow<SignUpPinUiState> = flow {
        emit(SignUpPinUiState.None)
    }.stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = SignUpPinUiState.None
    )
}