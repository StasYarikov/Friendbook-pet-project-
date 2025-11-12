package com.example.friendbook.presentation.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.friendbook.domain.repository.ChatMessagesRepository
import com.example.friendbook.domain.repository.FriendsRepository
import com.example.friendbook.presentation.chatScreen.ChatScreenViewModel
import com.example.friendbook.presentation.homeScreen.HomeScreenViewModel

class FriendsViewModelFactory(
    private val friendsRepository: FriendsRepository,
    private val chatMessagesRepository: ChatMessagesRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeScreenViewModel::class.java) -> {
                HomeScreenViewModel(friendsRepository) as T
            }
            modelClass.isAssignableFrom(ChatScreenViewModel::class.java) -> {
                ChatScreenViewModel(chatMessagesRepository) as T
            }
            else -> {
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.simpleName}")
            }
        }
    }
}