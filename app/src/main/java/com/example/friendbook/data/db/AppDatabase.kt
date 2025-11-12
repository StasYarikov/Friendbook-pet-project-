package com.example.friendbook.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.friendbook.data.db.dao.ChatMessagesDao
import com.example.friendbook.data.entity.Friend
import com.example.friendbook.data.db.dao.FriendDao
import com.example.friendbook.data.entity.ChatMessage

@Database(
    entities = [Friend::class, ChatMessage::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun friendsDao(): FriendDao
    abstract fun chatMessagesDao(): ChatMessagesDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration(false)
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}