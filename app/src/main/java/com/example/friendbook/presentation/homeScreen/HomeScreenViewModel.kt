package com.example.friendbook.presentation.homeScreen

import androidx.lifecycle.ViewModel
import com.example.friendbook.data.entity.Friend
import com.example.friendbook.domain.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeScreenViewModel(
    private val friendRepository: Repository
) : ViewModel() {

    var _friendsList = MutableStateFlow<List<Friend>>(emptyList())
    val friendsList = _friendsList.asStateFlow()
}