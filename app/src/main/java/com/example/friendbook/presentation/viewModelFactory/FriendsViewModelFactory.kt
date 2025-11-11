package com.example.friendbook.presentation.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.friendbook.presentation.homeScreen.HomeScreenViewModel
import com.example.friendbook.domain.repository.Repository

class FriendsViewModelFactory(
    private val friendsRepository: Repository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeScreenViewModel(friendsRepository) as T
    }
}