package com.finwise.core.data.remote.api.di

import com.finwise.core.data.remote.api.financenews.FinancialNewsApi
import com.finwise.core.data.remote.api.financenews.FinancialNewsApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiModule {
    @Binds
    @Singleton
    abstract fun bindFinancialNewsApi(financialNewsApiImpl: FinancialNewsApiImpl): FinancialNewsApi
}