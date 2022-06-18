package com.tab.news.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.tab.news.presentation.home.components.PostCard

@Composable
fun BookmarkScreen(viewModel: BookmarkViewModel = hiltViewModel()) {

    val viewState = viewModel.viewState

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(
                items = viewState.bookmarkedPosts,
            ) { bookmarkedContent ->
                PostCard(post = bookmarkedContent)
            }
        }
    }

}