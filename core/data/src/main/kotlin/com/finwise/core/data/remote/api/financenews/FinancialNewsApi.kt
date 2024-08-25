package com.finwise.core.data.remote.api.financenews

import com.finwise.core.data.BuildConfig
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface FinancialNewsApi {
    suspend fun getNews(): AllNewsResponse?
}

interface FinanceNewsService {
    @POST("/v1/news/all")
    suspend fun newsAll(
        @Query("countries") countries: String = "AU",
        @Query("limit") limit: Int = 3,
        @Query("filter_entities") filterEntities: Boolean = true,
        @Query("api_token") apiToken: String = BuildConfig.MARKETAUX_API_KEY,
    ): Response<AllNewsResponse>
}
