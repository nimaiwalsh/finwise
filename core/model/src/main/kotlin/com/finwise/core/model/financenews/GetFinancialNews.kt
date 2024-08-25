package com.finwise.core.model.financenews

fun interface GetFinancialNews {
    suspend fun getNews(): List<NewsItem>

    companion object {
        suspend operator fun GetFinancialNews.invoke(): List<NewsItem> = getNews()
    }
}