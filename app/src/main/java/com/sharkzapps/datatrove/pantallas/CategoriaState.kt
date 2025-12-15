package com.sharkzapps.datatrove.pantallas

interface CategoriaState {
    val favoritos: List<String>
    fun esFavorito(dato: String): Boolean
    fun cambiarFavorito(dato:String)
}