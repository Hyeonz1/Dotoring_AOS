package com.example.dotoring.ui.message.messageDetail


data class MessageDetailUiState (
    val chatList: List<MessageDetail> = listOf<MessageDetail> (),
    val writeContent: String = "",

    )

data class MessageDetail (
    val letterId:Long,
    val content:String,
    val writer: Boolean,
    val nickname: String,
    val createdAt:String,

    )
