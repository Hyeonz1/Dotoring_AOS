package com.example.dotoring.ui.message.messageDetail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MessageDetailViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(MessageDetailUiState())
    val uiState: StateFlow<MessageDetailUiState> = _uiState.asStateFlow()


    var messageInput by mutableStateOf("")
        private set

    var sendingButtonState by mutableStateOf(false)
        private set

    fun updateMessageInput(sendingMsg: String) {
        messageInput = sendingMsg

    }

    fun enableSendingButton() {
        sendingButtonState = true
    }


}