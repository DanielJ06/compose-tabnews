package com.tab.news.presentation.bookmark

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tab.news.domain.model.Content
import com.tab.news.domain.repository.ContentsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val repository: ContentsRepository
) : ViewModel() {

    init {
        getBookmarkedContent()
    }

    var viewState by mutableStateOf(BookmarkViewState())

    private fun getBookmarkedContent() {
        viewModelScope.launch {
            repository.getAllBookmarkContent().collect {
                if (it.isNotEmpty()) {
                    viewState = viewState.copy(
                        bookmarkedPosts = it
                    )
                }
            }
        }
    }

}