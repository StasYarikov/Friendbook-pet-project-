package com.example.friendbook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FriendsViewModelFactory(
    private val friendsRepository: Repository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeScreenViewModel(friendsRepository) as T
    }
}