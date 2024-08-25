package com.finwise.data.local.preferences

import kotlinx.coroutines.flow.Flow

interface AppPreferences {

    fun getEnvironment(): Flow<String?>
    suspend fun setEnvironment(environment: String): Result<Unit>
}
