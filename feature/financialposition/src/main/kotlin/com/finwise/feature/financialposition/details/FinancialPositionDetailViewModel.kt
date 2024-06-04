package com.finwise.feature.financialposition.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FinancialPositionDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    // accessing a nav arg from saved state handle
    private val financialPositionId: String = checkNotNull(
        savedStateHandle[FinancialPositionDetailDestination::financialPositionId.name]
    )

    val title = "Financial position details: $financialPositionId"
}