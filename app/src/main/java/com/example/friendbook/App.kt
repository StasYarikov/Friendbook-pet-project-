package com.example.friendbook

import android.app.Application
import com.example.friendbook.data.db.AppDatabase
import com.example.friendbook.domain.repository.Repository

class App: Application() {
    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }
    val repository: Repository by lazy {
        Repository(database.friendsDao())
    }
}