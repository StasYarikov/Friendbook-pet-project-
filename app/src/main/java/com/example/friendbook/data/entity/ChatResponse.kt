package com.example.friendbook.data.entity

data class ChatResponse(
    val choices: List<Choice>
)

data class Choice(
    val message: Message
)

data class Message(
    val content: String,
    val role: String
)