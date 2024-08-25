package com.finwise.core.data.repository.di

import com.finwise.core.data.repository.financenews.FinancialNewsRepositoryImpl
import com.finwise.core.model.financenews.GetFinancialNews
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindFinancialNewsRepository(financialNewsRepository: FinancialNewsRepositoryImpl): GetFinancialNews
}