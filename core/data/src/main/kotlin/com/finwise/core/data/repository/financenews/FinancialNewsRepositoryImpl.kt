package com.finwise.core.data.repository.financenews

import com.finwise.core.data.remote.api.financenews.FinancialNewsApi
import com.finwise.core.data.remote.api.financenews.toDomain
import com.finwise.core.model.financenews.GetFinancialNews
import com.finwise.core.model.financenews.NewsItem
import javax.inject.Inject

class FinancialNewsRepositoryImpl @Inject constructor(
    private val newsApi: FinancialNewsApi
) : GetFinancialNews {
    override suspend fun getNews(): List<NewsItem> {
        return newsApi.getNews()?.toDomain() ?: emptyList()
    }
}