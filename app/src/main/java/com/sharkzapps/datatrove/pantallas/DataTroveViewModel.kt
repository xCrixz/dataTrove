package com.sharkzapps.datatrove.pantallas

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sharkzapps.datatrove.pantallas.categorias.FavoritosDataStore
import kotlinx.coroutines.launch

class DataTroveViewModel(application: Application): AndroidViewModel(application),
CategoriaState{

    private val dataStore = FavoritosDataStore(application)
    private val _favoritos = mutableStateListOf<String>()

    override val favoritos: List<String>
        get() = _favoritos
    override fun esFavorito(dato: String): Boolean {
        return _favoritos.contains(dato)
    }

    init {
        viewModelScope.launch {
            dataStore.favoritos.collect { set ->
                _favoritos.clear()
                _favoritos.addAll(set)
            }
        }
    }

    override fun cambiarFavorito(dato: String) {
        if (_favoritos.contains(dato)){
            _favoritos.remove(dato)
        } else {
            _favoritos.add(dato)
        }
        viewModelScope.launch { dataStore.guardarFavoritos(_favoritos.toSet()) }
    }
}