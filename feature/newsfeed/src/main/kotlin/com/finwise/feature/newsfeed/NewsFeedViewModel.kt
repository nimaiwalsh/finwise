package com.finwise.feature.newsfeed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finwise.data.remote.api.AllNewsResponse
import com.finwise.data.repository.GetFinancialNews
import com.finwise.data.repository.GetFinancialNews.Companion.invoke
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class NewsFeedUiState(
    val newsItems: List<String>,
)

@HiltViewModel
class NewsFeedViewModel @Inject constructor(
    getNews: GetFinancialNews
) : ViewModel() {

    private val _state = MutableStateFlow(NewsFeedUiState(listOf("")))
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val newsResponse = getNews()
            _state.update { it.copy(newsItems = newsResponse.mapTpState()) }
        }
    }

    private fun AllNewsResponse?.mapTpState(): List<String> {
        if (this == null) return listOf()
        return this.data.map {
            it.title
        }
    }
}