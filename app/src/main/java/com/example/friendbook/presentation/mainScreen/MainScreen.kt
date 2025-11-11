package com.example.friendbook.presentation.mainScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.friendbook.presentation.chatScreen.ChatScreen
import com.example.friendbook.presentation.homeScreen.HomeScreen
import com.example.friendbook.presentation.homeScreen.HomeScreenViewModel
import com.example.friendbook.presentation.matchScreen.MatchScreen
import com.example.friendbook.presentation.profileScreen.ProfileScreen

@Composable
fun MainScreen(
    viewModel: HomeScreenViewModel
) {
    var selectedTab by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon( Icons.Default.Home, contentDescription = "Главная") },
                    label = { Text("Главная") },
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 }
                )
                NavigationBarItem(
                    icon = { Icon( Icons.Default.Create, contentDescription = "Чат") },
                    label = { Text("Чат") },
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1}
                )
                NavigationBarItem(
                    icon = { Icon( Icons.Default.CheckCircle, contentDescription = "Совместимость") },
                    label = { Text("Совместимость") },
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2}
                )
                NavigationBarItem(
                    icon = { Icon( Icons.Default.AccountBox, contentDescription = "Профиль") },
                    label = { Text("Профиль") },
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3}
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Добавить друга",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    ) {
            innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (selectedTab) {
                0 -> HomeScreen(viewModel)
                1 -> ChatScreen()
                2 -> MatchScreen()
                3 -> ProfileScreen()
            }
        }
    }
}