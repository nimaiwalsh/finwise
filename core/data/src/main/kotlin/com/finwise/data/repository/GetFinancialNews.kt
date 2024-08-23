package com.finwise.data.repository

import com.finwise.data.remote.api.AllNewsResponse

fun interface GetFinancialNews {
    // TODO update return type to return domain model
    suspend fun getNews(): AllNewsResponse?

    companion object {
        suspend operator fun GetFinancialNews.invoke(): AllNewsResponse? = getNews()
    }
}