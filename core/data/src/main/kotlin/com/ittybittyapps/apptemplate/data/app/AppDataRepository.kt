package com.ittybittyapps.apptemplate.data.app

import com.ittybittyapps.apptemplate.core.model.config.Environment
import kotlinx.coroutines.flow.Flow

interface AppDataRepository {
    fun getEnvironment(): Flow<Environment>
    suspend fun setEnvironment(environment: Environment): Result<Unit>
}
