package com.finwise.data.remote.api

import com.finwise.core.data.BuildConfig
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface FinancialNewsApi {
    suspend fun getNews(): AllNewsResponse?
}

interface StockNewsService {
    @POST("/v1/news/all")
    suspend fun newsAll(
        @Query("countries") countries: String = "AU",
        @Query("limit") limit: Int = 3,
        @Query("filter_entities") filterEntities: Boolean = true,
        @Query("api_token") apiToken: String = BuildConfig.MARKETAUX_API_KEY,
    ): Response<AllNewsResponse>
}

@Serializable
data class AllNewsResponse(
    @SerialName("meta") val meta: Meta,
    @SerialName("data") val data: List<NewsItem>,
) {
    @Serializable
    data class Meta(
        @SerialName("found") val found: Int,
        @SerialName("returned") val returned: Int,
        @SerialName("limit") val limit: Int,
        @SerialName("page") val page: Int,
    )

    @Serializable
    data class NewsItem(
        @SerialName("uuid") val id: String,
        @SerialName("title") val title: String,
    )
}