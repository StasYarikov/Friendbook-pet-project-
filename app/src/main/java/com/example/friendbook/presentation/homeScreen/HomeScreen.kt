package com.example.friendbook.presentation.homeScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.friendbook.App
import com.example.friendbook.presentation.viewModelFactory.FriendsViewModelFactory

@Composable
fun HomeScreen(
    onAddFriendClick: () -> Unit
) {
    val viewModel: HomeScreenViewModel = viewModel(
        factory = FriendsViewModelFactory(
            (LocalContext.current.applicationContext as App).repository
        )
    )
    val friends by viewModel.friendsList.collectAsState(initial = emptyList())
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadFriends()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(friends) { friend ->
            PersonItem(friend = friend)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}