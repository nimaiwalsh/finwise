package com.finwise.data.repository

fun interface GetFinancialNews {
    suspend fun getNews(): String

    companion object {
        suspend operator fun GetFinancialNews.invoke(): String = this.getNews()
    }
}