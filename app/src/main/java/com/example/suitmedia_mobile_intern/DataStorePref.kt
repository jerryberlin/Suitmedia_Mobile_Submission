package com.example.suitmedia_mobile_intern

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.suitmedia_mobile_intern.core.model.UserSession
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStorePref @Inject constructor(private val dataStore: DataStore<Preferences>) {

    fun getSession(): Flow<UserSession> {
        return dataStore.data.map { preferences ->
            UserSession(
                preferences[NAME] ?: "",
            )
        }
    }

    suspend fun saveSession(userSession: UserSession) {
        dataStore.edit { preferences ->
            preferences[NAME] = userSession.name
        }
    }

    companion object {
        private val NAME = stringPreferencesKey("name")
    }

}