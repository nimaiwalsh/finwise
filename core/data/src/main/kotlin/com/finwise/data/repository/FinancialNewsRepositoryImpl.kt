package com.finwise.data.repository

import com.finwise.data.remote.api.FinancialNewsApi
import javax.inject.Inject

class FinancialNewsRepositoryImpl @Inject constructor(
    private val newsApi: FinancialNewsApi
) : GetFinancialNews {
    override suspend fun getNews(): String = newsApi.getNews()
}