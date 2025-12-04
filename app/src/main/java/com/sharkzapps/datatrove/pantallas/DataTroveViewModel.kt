package com.sharkzapps.datatrove.pantallas

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class DataTroveViewModel: ViewModel() {

    private val _favoritos = mutableStateListOf<String>()
    val favoritos: List<String> get() = _favoritos

    fun cambiarFavorito(dato: String){
        if (_favoritos.contains(dato)){
            _favoritos.remove(dato)
        } else {
            _favoritos.add(dato)
        }
    }

    fun esFavorito(dato: String): Boolean{
        return _favoritos.contains(dato)
    }

}