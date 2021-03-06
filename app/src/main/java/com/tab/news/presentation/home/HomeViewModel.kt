package com.tab.news.presentation.home

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
class HomeViewModel @Inject constructor(
    private val navigation: HomeNavigation,
    private val repository: ContentsRepository,
) : ViewModel() {

    init {
        getContents()
    }

    var viewState by mutableStateOf(HomeViewState())

    fun navigateToContentDetails(content: Content) {
        navigation.navigateToNextPage(content)
    }

    fun navigateToBookmarked() {
        navigation.navigateToBookmarked()
    }

    private fun getContents() {
        viewModelScope.launch {
            repository.getAllContents().collect {
                if (it.isNotEmpty()) {
                    viewState = viewState.copy(contents = it)
                }
            }
        }
    }

}