package com.finwise.core.data.remote.api.financenews

import android.util.Log
import retrofit2.Retrofit
import javax.inject.Inject

class FinancialNewsApiImpl @Inject constructor(
    retrofit: Retrofit,
) : FinancialNewsApi {

    private val newsService = retrofit.create(FinanceNewsService::class.java)

    override suspend fun getNews(): AllNewsResponse? {
        // TODO create an interceptor to return a kotlin Result and handle errors
        val response = newsService.newsAll().body()
        Log.d("STOCK_NEWS_SERVICE", "getNews: $response")
        return response
    }
}