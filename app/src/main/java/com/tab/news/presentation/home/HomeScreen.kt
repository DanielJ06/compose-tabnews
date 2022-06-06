package com.tab.news.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val viewState = viewModel.viewState

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Button(onClick = { viewModel.teste() }) {
            Text(text = "Olá, seja bem vindo ao TabNews")
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                items = viewState.contents
            ) { content ->
                Text(text = content.title)
            }
        }
    }

}