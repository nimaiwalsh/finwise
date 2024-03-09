package com.finwise.feature.financialposition

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FinancialPositionViewModel @Inject constructor() : ViewModel() {
    val title = "Financial position"
}