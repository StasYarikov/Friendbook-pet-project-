package com.example.friendbook.presentation.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.friendbook.data.entity.Friend
import com.example.friendbook.domain.repository.Repository
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val friendRepository: Repository
) : ViewModel() {

    var _friendsList = MutableStateFlow<List<Friend>>(emptyList())
    val friendsList = _friendsList.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadFriends()
    }

    fun loadFriends() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                friendRepository.getAllFriends().collect { friendsList ->
                    _friendsList.value = friendsList
                    _isLoading.value = false
                }
            } catch (e: Exception) {
                _error.value = "Ошибка загрузки: ${e.message}"
                _isLoading.value = false
            }
        }
    }

    fun addFriend(name: String, phone: String, avatarURL: String?) {
        viewModelScope.launch {
            friendRepository.addFriend(name, phone, avatarURL)
        }
    }
}