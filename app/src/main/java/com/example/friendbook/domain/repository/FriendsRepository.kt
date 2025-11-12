package com.example.friendbook.domain.repository

import com.example.friendbook.data.db.dao.FriendDao
import com.example.friendbook.data.entity.Friend
import kotlinx.coroutines.flow.Flow

class FriendsRepository(private val friendDao: FriendDao) {

    suspend fun addFriend(name: String, phone: String, avatarUrl: String? = null): Long {
        val friend = Friend(name = name, phone = phone, avatarUrl = avatarUrl)
        return friendDao.insert(friend)
    }

    suspend fun update(friend: Friend): Int {
        return friendDao.update(friend)
    }

    suspend fun deleteFriend(friend: Friend): Int {
        return friendDao.delete(friend)
    }

    suspend fun deleteFriendById(friendId: Long): Int {
        return friendDao.deleteById(friendId)
    }

    fun getAllFriends(): Flow<List<Friend>> {
        return friendDao.getAllFriends()
    }

    suspend fun getFriendById(friendId: Long): Friend? {
        return friendDao.getFriendById(friendId)
    }
}