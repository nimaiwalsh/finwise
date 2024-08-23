package com.finwise.data.repository

import com.finwise.data.remote.api.AllNewsResponse
import com.finwise.data.remote.api.FinancialNewsApi
import javax.inject.Inject

class FinancialNewsRepositoryImpl @Inject constructor(
    private val newsApi: FinancialNewsApi
) : GetFinancialNews {
    // TODO map to domain model
    override suspend fun getNews(): AllNewsResponse? = newsApi.getNews()
}