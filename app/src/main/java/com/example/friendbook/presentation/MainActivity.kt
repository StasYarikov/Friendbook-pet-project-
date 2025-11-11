package com.example.friendbook.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.friendbook.ui.theme.FriendbookTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.friendbook.App
import com.example.friendbook.presentation.viewModelFactory.FriendsViewModelFactory
import com.example.friendbook.presentation.homeScreen.HomeScreenViewModel
import com.example.friendbook.data.entity.Friend
import com.example.friendbook.presentation.mainScreen.MainScreen


class MainActivity : ComponentActivity() {

    private lateinit var viewModel: HomeScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val application = applicationContext as App
        val factory = FriendsViewModelFactory(application.repository)
        viewModel = ViewModelProvider(this, factory)[HomeScreenViewModel::class.java]

        setContent {
            FriendbookTheme {
                MainScreen(viewModel)
            }
        }
    }
}