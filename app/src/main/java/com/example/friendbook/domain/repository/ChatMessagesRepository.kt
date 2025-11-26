package com.example.friendbook.domain.repository

import com.example.friendbook.data.db.dao.ChatMessagesDao
import com.example.friendbook.data.entity.ChatMessage
import com.example.friendbook.data.entity.ChatRequest
import com.example.friendbook.data.entity.ChatResponse
import com.example.friendbook.data.entity.Friend
import com.example.friendbook.data.entity.Message
import com.example.friendbook.data.entity.TokenResponse
import com.example.friendbook.data.service.GigaChatApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow

class ChatMessagesRepository(
    private val chatMessagesDao: ChatMessagesDao,
    private val gigaChatApi: GigaChatApi
) {

    suspend fun sendMessage(userMessage: String): ApiResult<ChatResponse> {

        return try {
            val request = ChatRequest(
                messages = listOf(
                    Message(role = "user", content = userMessage)
                )
            )
            val response = gigaChatApi.sendMessage("", request)
            ApiResult.Success(response)
        } catch (e: Exception) {
            ApiResult.Error(e)
        }
    }

    suspend fun getToken(authKey: String): ApiResult<TokenResponse> {
        return try {
            val response = gigaChatApi.getToken("Basic $authKey")
            ApiResult.Success(response)
        } catch (e: Exception) {
            ApiResult.Error(e)
        }
    }

    suspend fun addMessage(message: String, isUser: Boolean): Long {
        return chatMessagesDao.insert(ChatMessage(text = message, isUser = isUser))
    }

    suspend fun deleteAllMessages(): Int {
        return chatMessagesDao.deleteAllMessages()
    }

    fun getAllMessages(): Flow<List<ChatMessage>> {
        return chatMessagesDao.getAllMessages()
    }
}

sealed interface ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>
    data class Error(val exception: Throwable): ApiResult<Nothing>
}