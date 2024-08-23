package com.finwise.data.remote.api

import android.util.Log
import retrofit2.Retrofit
import javax.inject.Inject

class FinancialNewsApiImpl @Inject constructor(
    retrofit: Retrofit,
) : FinancialNewsApi {

    private val newsService = retrofit.create(StockNewsService::class.java)

    override suspend fun getNews(): AllNewsResponse? {
        // TODO create an interceptor to return a kotlin Result and handle errors
        val response = newsService.newsAll().body()
        Log.d("STOCK_NEWS_SERVICE", "getNews: $response")
        return response
    }
}