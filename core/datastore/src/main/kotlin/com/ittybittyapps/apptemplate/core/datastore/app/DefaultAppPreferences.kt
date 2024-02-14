package com.ittybittyapps.apptemplate.core.datastore.app

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultAppPreferences(
    private val dataStore: DataStore<Preferences>
) : AppPreferences {
    override fun getEnvironment(): Flow<String?> {
        return dataStore.data
            .map { preferences ->
                preferences[stringPreferencesKey(ENVIRONMENT)]
            }
    }

    override suspend fun setEnvironment(environment: String): Result<Unit> {
        return runCatching {
            dataStore.edit { preferences ->
                preferences.apply {
                    preferences[stringPreferencesKey(ENVIRONMENT)] = environment
                }
            }
        }
    }

    companion object {
        const val ENVIRONMENT = "environment"
    }
}
