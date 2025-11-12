package com.example.friendbook.domain.repository

import com.example.friendbook.data.db.dao.ChatMessagesDao
import com.example.friendbook.data.entity.ChatMessage
import com.example.friendbook.data.entity.Friend
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow

class ChatMessagesRepository(private val chatMessagesDao: ChatMessagesDao) {

    suspend fun sendMessage(userMessage: String): String {
        // временная заглушка
        delay(1000)

        return when (userMessage.lowercase()) {
            "привет" -> "Привет! Чем могу помочь?"
            "как дела?" -> "У меня всё отлично! А у вас?"
            "что ты умеешь?" -> "Я могу отвечать на вопросы и помогать с различными задачами"
            else -> "Я получил ваше сообщение: \"$userMessage\". Это тестовая версия чата."
        }
    }

    suspend fun addMessage(message: String, isUser: Boolean): Long {
        return chatMessagesDao.insert(ChatMessage(text = message, isUser = isUser))
    }

    fun getAllMessages(): Flow<List<ChatMessage>> {
        return chatMessagesDao.getAllMessages()
    }
}