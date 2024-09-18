package com.afs.tutrd.common.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

const val TUTOR = "tutor"
const val TUTEE = "tutee"

class TutrdRoleDataStore(val context: Context) {
    companion object {
        private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = "tutrdRole")
        val TUTRD_ROLE = stringPreferencesKey("tutrdRole")
    }

    val getTutrdRole: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[TUTRD_ROLE] ?: TUTOR
        }

    suspend fun initializeTutrdRole(role: String) {
        context.dataStore.edit { preferences ->
            preferences[TUTRD_ROLE] = role
        }
    }

    suspend fun switchTutrdRole() {
        context.dataStore.edit { preferences ->
            if(preferences[TUTRD_ROLE] == TUTOR) TUTEE
            else TUTOR
        }
    }
}