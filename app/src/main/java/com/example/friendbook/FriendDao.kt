package com.example.friendbook

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FriendDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(friend: Friend): Long

    @Update
    suspend fun update(friend: Friend): Int

    @Delete
    suspend fun delete(friend: Friend): Int

    @Query("DELETE FROM friends WHERE id = :friendId")
    suspend fun deleteById(friendId: Long): Int

    @Query("SELECT * FROM friends ORDER BY name ASC")
    fun getAllFriends(): Flow<List<Friend>>

    @Query("SELECT * FROM friends WHERE id = :friendId")
    suspend fun getFriendById(friendId: Long): Friend?

    @Query("SELECT * FROM friends WHERE phone = :phoneNumber")
    suspend fun getFriendByPhone(phoneNumber: String): Friend?

}