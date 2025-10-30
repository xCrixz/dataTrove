package com.sharkzapps.datatrove.pantallas.categorias

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sharkzapps.datatrove.ui.theme.garamondFamily
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import com.sharkzapps.datatrove.pantallas.Encabezado

@Composable
fun CategoriaVideoJ(onMenuClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFFEE5),
                        Color(0xFFA92375)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp, 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Encabezado(onMenuClick)
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "Videojuegos",
                fontSize = 35.sp,
                style = TextStyle(fontFamily = garamondFamily, fontWeight = FontWeight.Black),
                modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Start)
            HorizontalDivider(modifier = Modifier.height(5.dp)
                .width(230.dp)
                .align(Alignment.Start),
                thickness = 3.5.dp,
                color = Color.Black)
        }
    }
}

@Preview(showBackground = true, apiLevel = 34)
@Composable
fun PreviewCategoriaVideoJ() {
    CategoriaVideoJ(onMenuClick = {})
}