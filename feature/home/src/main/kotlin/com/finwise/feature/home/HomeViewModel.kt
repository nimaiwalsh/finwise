package com.finwise.feature.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class HomeUiState(
    val welcomeText: String,
)

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState(welcomeText = ""))
    val state get() = _state.asStateFlow()

    init {
        _state.update {
            it.copy(welcomeText = "Welcome to FinWise!\n please select a tool below")
        }
    }
}
