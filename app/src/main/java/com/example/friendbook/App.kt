package com.example.friendbook

import android.app.Application

class App: Application() {
    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }
    val repository: Repository by lazy {
        Repository(database.friendsDao())
    }
}