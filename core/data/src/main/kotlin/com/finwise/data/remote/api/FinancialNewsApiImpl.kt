package com.finwise.data.remote.api

import com.finwise.core.data.BuildConfig
import javax.inject.Inject

class FinancialNewsApiImpl @Inject constructor() : FinancialNewsApi {

    private val apiKey = BuildConfig.MARKETAUX_API_KEY

    override fun getNews(): String = apiKey
}