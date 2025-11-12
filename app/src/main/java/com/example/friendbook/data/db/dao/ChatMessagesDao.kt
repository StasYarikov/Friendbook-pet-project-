package com.example.friendbook.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.friendbook.data.entity.ChatMessage
import com.example.friendbook.data.entity.Friend
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatMessagesDao {
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(message: ChatMessage): Long

    @Update
    suspend fun update(message: ChatMessage): Int

    @Delete
    suspend fun delete(message: ChatMessage): Int

    @Query("DELETE FROM chat_messages WHERE id = :chatMessageId")
    suspend fun deleteById(chatMessageId: Long): Int

    @Query("SELECT * FROM chat_messages ORDER BY timeStamp ASC")
    fun getAllMessages(): Flow<List<ChatMessage>>

    @Query("SELECT * FROM chat_messages WHERE id = :messageId")
    suspend fun getMessageById(messageId: Long): ChatMessage?
}