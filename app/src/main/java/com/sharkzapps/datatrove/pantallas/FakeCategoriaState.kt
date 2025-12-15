package com.sharkzapps.datatrove.pantallas

import androidx.compose.runtime.mutableStateListOf

class FakeCategoriaState : CategoriaState {

    private val _favoritos = mutableStateListOf<String>()

    override val favoritos: List<String>
        get() = _favoritos

    override fun esFavorito(dato: String): Boolean {
        return _favoritos.contains(dato)
    }

    override fun cambiarFavorito(dato: String) {
        if (_favoritos.contains(dato)) _favoritos.remove(dato)
        else _favoritos.add(dato)
    }
}