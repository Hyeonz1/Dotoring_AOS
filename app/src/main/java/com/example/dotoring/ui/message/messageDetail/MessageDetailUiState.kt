package com.example.dotoring.ui.message.messageDetail

import com.example.dotoring.ui.message.messageDetail.data.MessageDetail

data class MessageDetailUiState (
    val chatList: List<MessageDetail> = listOf<MessageDetail> (),
    val content: String = "",

    )
