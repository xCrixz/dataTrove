package com.sharkzapps.datatrove.pantallas.categorias

import android.content.Context

import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore("favoritos_datastore")

class FavoritosDataStore(private val context: Context) {
    private val FAVORITOS_KEY = stringSetPreferencesKey("favoritos_key")

    // Obtener favoritos como Flow
    val favoritos: Flow<Set<String>> = context.dataStore.data.map { prefs ->
        prefs[FAVORITOS_KEY] ?: emptySet()
    }

    // Guardar favoritos
    suspend fun guardarFavoritos(lista: Set<String>) {
        context.dataStore.edit { prefs ->
            prefs[FAVORITOS_KEY] = lista
        }
    }
}