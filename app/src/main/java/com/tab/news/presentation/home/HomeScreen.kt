package com.tab.news.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tab.news.presentation.home.components.PostCard

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val viewState = viewModel.viewState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Button(onClick = {}) {
                Text(text = "Create a reading list")
            }

            Button(onClick = {}) {
                Text(text = "See your reading lists")
            }
        }
        LazyColumn(
            contentPadding = PaddingValues(vertical = 15.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(horizontal = 20.dp)
        ) {
            items(
                items = viewState.contents,
            ) { content ->
                Box(
                    modifier = Modifier
                        .clickable {
                            viewModel.navigateToContentDetails(content)
                        }
                ) {
                    PostCard(post = content)
                    Spacer(modifier = Modifier.size(15.dp))
                }
            }
        }
    }

}