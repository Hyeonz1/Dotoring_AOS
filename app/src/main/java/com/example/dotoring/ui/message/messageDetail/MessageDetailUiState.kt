package com.example.dotoring.ui.message.messageDetail

data class MessageDetailUiState (
    val chatList: List<MessageDetail> = listOf<MessageDetail> (),
    val content: String = "",

    )
data class MessageDetail(
    val nickname: String="",
    val letterId: Int = 1 ,
    val content: String="",
    val writer: Boolean = true,
    val createdAt: String="",
)