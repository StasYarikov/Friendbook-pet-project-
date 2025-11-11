package com.example.friendbook.presentation.homeScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel
) {
    val friends by viewModel.friendsList.collectAsState()
//    val friends = remember {
//        FriendGenerator.generateFriends(10)
//        FriendGenerator.listOfFriends
//    }

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