package com.sharkzapps.datatrove.pantallas.categorias

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import com.sharkzapps.datatrove.ui.theme.garamondFamily
import com.sharkzapps.datatrove.pantallas.Encabezado
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sharkzapps.datatrove.pantallas.datos.datosCiencia

@Composable
fun CategoriaCiencia(navController: NavController? = null) {

    var index by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFFEE5),
                        Color(0xFF00B4D8)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp, 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val controller = navController ?: rememberNavController()
            Encabezado(navController = controller, onMenuClick = {})
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Ciencia",
                fontSize = 35.sp,
                style = TextStyle(fontFamily = garamondFamily, fontWeight = FontWeight.Black),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start)
            HorizontalDivider(modifier = Modifier
                .height(5.dp)
                .width(230.dp)
                .align(Alignment.Start),
                thickness = 3.5.dp,
                color = Color.Black)
            
            Spacer(modifier = Modifier.height(40.dp))
            DatoAleatorio(dato = datosCiencia[index])
            Spacer(modifier = Modifier.height(45.dp))

            HorizontalDivider(modifier = Modifier
                .height(5.dp)
                .width(230.dp)
                .align(Alignment.End),
                thickness = 3.5.dp, color = Color.Black)

            BotonesNavAcciones(
                onAnteriorClick = {index = datosCiencia.indices.random()},
                onSiguienteClick = {index = datosCiencia.indices.random()},
                onCompartirClick = {},
                onFavoritoClick = {})
        }
    }
}

@Preview(showBackground = true, apiLevel = 34)
@Composable
fun PreviewCategoriaCiencia() {
    CategoriaCiencia()
}