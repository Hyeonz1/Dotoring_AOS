package com.example.dotoring.ui.message.messageBox


data class MessageBoxUiState (
    val messageList: List<MessageBox> = listOf<MessageBox> (),

        )
data class MessageBox(
    val roomPK: Long = 1 ,
    val memberPK: Long = 1 ,
    val nickname: String ="",
    val lastLetter: String="",
    val updateAt: String=""
)