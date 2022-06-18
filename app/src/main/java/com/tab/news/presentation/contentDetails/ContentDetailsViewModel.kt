package com.tab.news.presentation.contentDetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tab.news.domain.model.Content
import com.tab.news.domain.repository.ContentsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContentDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val contentsRepository: ContentsRepository
) : ViewModel() {

    var viewState by mutableStateOf(ContentDetailsViewState())

    init {
        val postContent = savedStateHandle.get<Content>("postContent")
        postContent?.let {
            viewState = viewState.copy(contentDetail = it)
            verifyIfIsBookmarked(it.id)
        }
    }

    private fun verifyIfIsBookmarked(postContentId: String) {
        viewModelScope.launch {
            val isBookmarked = contentsRepository.verifyIfIsBookmarked(postContentId = postContentId)
            viewState = viewState.copy(
                isBookmarked = isBookmarked
            )
        }
    }

    fun handleBookmark(postContent: Content) {
        viewModelScope.launch {
            contentsRepository.bookmarkContent(postContent)
            viewState = viewState.copy(isBookmarked = true)
        }
    }

}