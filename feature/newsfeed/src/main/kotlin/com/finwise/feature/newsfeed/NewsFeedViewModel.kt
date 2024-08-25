package com.finwise.feature.newsfeed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finwise.core.model.financenews.GetFinancialNews
import com.finwise.core.model.financenews.GetFinancialNews.Companion.invoke
import com.finwise.core.model.financenews.NewsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class NewsFeedUiState(
    val newsItems: List<NewsItem>,
)

@HiltViewModel
class NewsFeedViewModel @Inject constructor(
    getNews: GetFinancialNews
) : ViewModel() {

    private val _state = MutableStateFlow(NewsFeedUiState(emptyList()))
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val news = getNews()
            _state.update { it.copy(newsItems = news) }
        }
    }
}