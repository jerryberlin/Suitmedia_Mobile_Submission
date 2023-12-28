package com.example.suitmedia_mobile_intern.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

object Constants {
    const val USERNAME = "username"

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "User")
}