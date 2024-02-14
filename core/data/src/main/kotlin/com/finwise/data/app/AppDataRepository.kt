package com.finwise.data.app

import com.finwise.core.model.config.Environment
import kotlinx.coroutines.flow.Flow

interface AppDataRepository {
    fun getEnvironment(): Flow<Environment>
    suspend fun setEnvironment(environment: Environment): Result<Unit>
}
