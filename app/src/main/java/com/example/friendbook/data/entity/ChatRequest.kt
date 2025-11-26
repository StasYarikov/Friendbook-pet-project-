package com.example.friendbook.data.entity

import com.google.gson.annotations.SerializedName

data class ChatRequest(
    val model: String = "GigaChat",
    val messages: List<Message>,
    val temperature: Double = 0.7,
    @SerializedName("max_tokens")
    val maxTokens: Int = 512
)