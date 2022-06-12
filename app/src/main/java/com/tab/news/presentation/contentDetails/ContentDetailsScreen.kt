package com.tab.news.presentation.contentDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.jeziellago.compose.markdowntext.MarkdownText

@Composable
fun ContentDetailsScreen(viewModel: ContentDetailsViewModel = hiltViewModel()) {

    val viewState = viewModel.viewState

    viewModel.viewState.contentDetail?.let { postContent ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(20.dp)
        ) {
            Text(
                text = postContent.title,
                color = MaterialTheme.colors.error,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            MarkdownText(
                markdown = postContent.body,
                color = Color.White
            )
        }
    }

}