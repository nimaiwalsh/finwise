package com.finwise.data.remote.api.di

import com.finwise.data.remote.api.FinancialNewsApi
import com.finwise.data.remote.api.FinancialNewsApiImpl
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
    abstract fun bindFinancialNewsApi(financialNewsApi: FinancialNewsApiImpl): FinancialNewsApi
}