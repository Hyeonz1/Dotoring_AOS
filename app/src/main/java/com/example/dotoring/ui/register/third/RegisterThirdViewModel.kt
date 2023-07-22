package com.example.dotoring.ui.register.third

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.update

class RegisterThirdViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(RegisterThirdUiState())
    val uiState: StateFlow<RegisterThirdUiState> = _uiState.asStateFlow()

    var nickname by mutableStateOf("")
        private set

    var btnState by mutableStateOf(false)

    var nicknameCertification by mutableStateOf("")
        private set

    fun updateNickname(nicknameInput: String) {
        nickname = nicknameInput

        _uiState.update { currentState ->
            currentState.copy(nickname = nicknameInput)
        }
    }

    fun enableBtnState() {
        btnState = true

        _uiState.update { currentState ->
            currentState.copy(btnState = btnState)
        }
    }
}