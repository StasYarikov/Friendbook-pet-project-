package com.example.friendbook

import android.app.Application
import com.example.friendbook.data.db.AppDatabase
import com.example.friendbook.domain.repository.ChatMessagesRepository
import com.example.friendbook.domain.repository.FriendsRepository

class App: Application() {
    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }
    val friendsRepository: FriendsRepository by lazy {
        FriendsRepository(database.friendsDao())
    }
    val chatMessagesRepository: ChatMessagesRepository by lazy {
        ChatMessagesRepository(database.chatMessagesDao())
    }
}