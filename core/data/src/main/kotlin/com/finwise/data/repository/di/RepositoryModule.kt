package com.finwise.data.repository.di

import com.finwise.data.repository.FinancialNewsRepositoryImpl
import com.finwise.data.repository.GetFinancialNews
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