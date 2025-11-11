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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.friendbook.presentation.addFriendScreen.AddFriendScreen
import com.example.friendbook.presentation.chatScreen.ChatScreen
import com.example.friendbook.presentation.homeScreen.HomeScreen
import com.example.friendbook.presentation.homeScreen.HomeScreenViewModel
import com.example.friendbook.presentation.matchScreen.MatchScreen
import com.example.friendbook.presentation.profileScreen.ProfileScreen
import com.example.friendbook.presentation.mainScreen.Tab.*

@Composable
fun MainScreen(
    viewModel: HomeScreenViewModel
) {
    val navController = rememberNavController()

    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination

    val currentTab = when (currentDestination?.route) {
        "home", "addFriend" -> Home
        "chat" -> Chat
        "match" -> Match
        "profile" -> Profile
        else -> Home
    }

    val shouldShowBottomBar = currentDestination?.route in listOf("home", "chat", "match", "profile")

    val shouldShowFab = currentDestination?.route == "home"

    Scaffold(
        bottomBar = {
            if (shouldShowBottomBar) {
                NavigationBar {
                    NavigationBarItem(
                        icon = { Icon( Icons.Default.Home, contentDescription = "Главная") },
                        label = { Text("Главная") },
                        selected = currentTab == Home,
                        onClick = {
                            if (currentTab != Home) {
                                navController.navigate("home") {
                                    popUpTo("home") { inclusive = true }
                                }
                            }
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon( Icons.Default.Create, contentDescription = "Чат") },
                        label = { Text("Чат") },
                        selected = currentTab == Chat,
                        onClick = {
                            if (currentTab != Chat) {
                                navController.navigate("chat") {
                                    popUpTo("chat") { inclusive = true }
                                }
                            }
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon( Icons.Default.CheckCircle, contentDescription = "Совместимость") },
                        label = { Text("Совместимость") },
                        selected = currentTab == Match,
                        onClick = {
                            if (currentTab != Match) {
                                navController.navigate("match") {
                                    popUpTo("match") { inclusive = true }
                                }
                            }
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon( Icons.Default.AccountBox, contentDescription = "Профиль") },
                        label = { Text("Профиль") },
                        selected = currentTab == Profile,
                        onClick = {
                            if (currentTab != Profile) {
                                navController.navigate("profile") {
                                    popUpTo("profile") { inclusive = true }
                                }
                            }
                        }
                    )
                }
            }
        },
        floatingActionButton = {
            if (shouldShowFab) {
                FloatingActionButton(
                    onClick = {
                        navController.navigate("addFriend")
                    },
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Добавить друга",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen(
                    onAddFriendClick = { navController.navigate("addFriend") }
                )
            }
            composable("chat") {
                ChatScreen()
            }
            composable("match") {
                MatchScreen()
            }
            composable("profile") {
                ProfileScreen()
            }

            composable("addFriend") {
                AddFriendScreen(
                    onBack = { navController.popBackStack() },
                    onFriendAdded = {
                        navController.navigate("home") {
                            popUpTo("home") {
                                inclusive = true
                            }
                        }
                    }
                )
            }

        }
    }
}