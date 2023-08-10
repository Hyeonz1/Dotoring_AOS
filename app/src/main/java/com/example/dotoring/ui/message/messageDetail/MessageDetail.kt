package com.example.dotoring.ui.message.messageDetail

import android.provider.ContactsContract.CommonDataKinds.Nickname
import java.io.FileWriter

data class MessageDetail (
    val letterId:Long,
    val content:String,
    val writer: Boolean,
    val nickname: String,
    val createdAt:String,

    )
