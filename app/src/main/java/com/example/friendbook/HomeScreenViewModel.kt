package com.example.friendbook

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeScreenViewModel(
    private val friendRepository: Repository
) : ViewModel() {

    var _friendsList = MutableStateFlow<List<Friend>>(emptyList())
    val friendsList = _friendsList.asStateFlow()
}