package com.tab.news

import androidx.lifecycle.ViewModel
import com.tab.news.intent.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TabNewsViewModel @Inject constructor(
    val navigator: Navigator
) : ViewModel() {
}