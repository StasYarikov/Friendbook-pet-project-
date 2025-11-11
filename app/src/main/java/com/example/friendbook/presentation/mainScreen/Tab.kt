package com.example.friendbook.presentation.mainScreen

sealed class Tab(val route: String) {
    object Home: Tab("home")
    object Chat: Tab("chat")
    object Match: Tab("match")
    object Profile: Tab("profile")
}