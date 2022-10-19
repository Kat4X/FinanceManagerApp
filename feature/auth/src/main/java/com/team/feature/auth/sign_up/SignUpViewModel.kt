package com.team.feature.auth.sign_up

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


sealed interface SignUpUiState {
    object None : SignUpUiState
}

@OptIn(SavedStateHandleSaveableApi::class)
@HiltViewModel
class SignUpViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    var emailField by savedStateHandle.saveable{
        mutableStateOf("")
    }
    var passwordField:String by mutableStateOf("")
        private set
    val signUpState: Flow<SignUpUiState> = flow {
        emit(SignUpUiState.None)
    }.stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = SignUpUiState.None
    )
}
