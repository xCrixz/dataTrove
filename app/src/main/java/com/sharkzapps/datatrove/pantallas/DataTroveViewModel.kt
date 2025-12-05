package com.sharkzapps.datatrove.pantallas

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sharkzapps.datatrove.pantallas.categorias.FavoritosDataStore
import kotlinx.coroutines.launch

open class DataTroveViewModel(application: Application): AndroidViewModel(application) {

    private val dataStore = FavoritosDataStore(application)
    private val _favoritos = mutableStateListOf<String>()
    val favoritos: List<String> get() = _favoritos

    init {
        viewModelScope.launch {
            dataStore.favoritos.collect{ set ->
                _favoritos.clear()
                _favoritos.addAll(set)

            }
        }
    }

    open fun cambiarFavorito(dato: String){
        if (_favoritos.contains(dato)){
            _favoritos.remove(dato)
        } else {
            _favoritos.add(dato)
        }
        viewModelScope.launch {
            dataStore.guardarFavoritos(_favoritos.toSet())
        }
    }

    fun esFavorito(dato: String): Boolean{
        return _favoritos.contains(dato)
    }

}