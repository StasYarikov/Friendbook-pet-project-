package com.example.friendbook

import android.app.Application
import com.example.friendbook.data.db.AppDatabase
import com.example.friendbook.data.service.GigaChatApi
import com.example.friendbook.data.service.RetrofitClient
import com.example.friendbook.domain.repository.ChatMessagesRepository
import com.example.friendbook.domain.repository.FriendsRepository

class App: Application() {

    private val authKey = "OTBkMzA3NjItMzMwNS00N2RiLWE1NTgtOWQyNTYzYzVmMjFiOmMwNTZmYmE4LWEwNWUtNDZhNS05NDNiLWUyNmVkNDEzMWQ2OA=="
    private lateinit var gigaChatApi: GigaChatApi

    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }
    val friendsRepository: FriendsRepository by lazy {
        FriendsRepository(database.friendsDao())
    }
    val chatMessagesRepository: ChatMessagesRepository by lazy {
        ChatMessagesRepository(
            database.chatMessagesDao(),
            gigaChatApi = gigaChatApi
        )
    }

    override fun onCreate() {
        super.onCreate()
        gigaChatApi = RetrofitClient.createGigaChatApi(this, authKey)
    }
}