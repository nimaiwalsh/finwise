package com.finwise.feature.calculators.compoundinterest

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CompoundInterestViewModel @Inject constructor() : ViewModel() {
    val title = "Compound Interest Calculator"
}