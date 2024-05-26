package com.finwise.data.api.di

import com.finwise.data.api.FinancialNewsApi
import com.finwise.data.api.FinancialNewsApiImpl
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
    abstract fun bindFinancialNewsApis(financialNewsApi: FinancialNewsApiImpl): FinancialNewsApi
}