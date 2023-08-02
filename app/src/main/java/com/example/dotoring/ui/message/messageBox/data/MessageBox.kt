package com.example.dotoring.ui.message.messageBox.data

data class MessageBox(
val roomPK: Long,
val memberPK: Long,
val nickname: String,
val lastLetter: String,
val major: String,
val updateAt: String )