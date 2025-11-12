package com.example.friendbook.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chat_messages")
data class ChatMessage(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo
    val text: String = "",

    @ColumnInfo
    val isUser: Boolean = true,

    @ColumnInfo
    val timeStamp: Long = System.currentTimeMillis()

)