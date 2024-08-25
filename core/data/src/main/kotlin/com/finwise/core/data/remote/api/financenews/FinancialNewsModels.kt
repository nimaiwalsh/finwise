package com.finwise.core.data.remote.api.financenews

import com.finwise.core.model.financenews.NewsItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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

fun AllNewsResponse.toDomain(): List<NewsItem> = this.data.map { item ->
    NewsItem(
        id = item.id,
        title = item.title
    )
}
