package com.sharkzapps.datatrove.pantallas

import androidx.compose.ui.graphics.Color

data class Categoria(val nombre:String, val color: Color, val emoji:String)

val populares = listOf(Categoria("Amor", Color(0xFFFF708D), "❤️"),
    Categoria("Tecnología", Color(0xFF6FB3FF), "📻"))

val curiosas = listOf(Categoria("Arte", Color(0xFFD96C6C), "🎨"))