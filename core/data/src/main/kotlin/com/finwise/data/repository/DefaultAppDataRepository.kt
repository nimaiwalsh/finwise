package com.finwise.data.repository

import com.finwise.data.preferences.AppPreferences
import com.finwise.core.model.config.Environment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultAppDataRepository constructor(
    private val appPreferences: AppPreferences
) : AppDataRepository {

    override fun getEnvironment(): Flow<Environment> {
        return appPreferences.getEnvironment()
            .map { environmentString ->
                Environment.fromString(environmentString)
            }
    }

    override suspend fun setEnvironment(environment: Environment): Result<Unit> {
        return appPreferences.setEnvironment(environment.name)
    }
}
