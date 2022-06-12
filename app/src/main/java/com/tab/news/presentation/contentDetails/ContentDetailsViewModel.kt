package com.tab.news.presentation.contentDetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.tab.news.domain.model.Content
import com.tab.news.presentation.home.HomeNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContentDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var viewState by mutableStateOf(ContentDetailsViewState())

    init {
        val postContent = savedStateHandle.get<Content>("postContent")
        postContent?.let {
            viewState = viewState.copy(contentDetail = it)
        }
    }

}