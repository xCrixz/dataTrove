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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sharkzapps.datatrove.pantallas.Encabezado
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sharkzapps.datatrove.pantallas.DataTroveViewModel
import com.sharkzapps.datatrove.pantallas.datos.datosVideoJuegos

@Composable
fun CategoriaVideoJ(navController: NavController? = null,
                    viewModel: DataTroveViewModel = viewModel()
) {

    var index by remember { mutableIntStateOf(0) }
    var direccion by remember { mutableIntStateOf(1) }

    val textoActual = datosVideoJuegos[index]
    val esFavorito = viewModel.esFavorito(textoActual)

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
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp, 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val controller = navController ?: rememberNavController()
            Encabezado(navController = controller, onMenuClick = {})
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Videojuegos",
                fontSize = 35.sp,
                style = TextStyle(fontFamily = garamondFamily, fontWeight = FontWeight.Black),
                modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Start)
            HorizontalDivider(modifier = Modifier
                .height(5.dp)
                .width(230.dp)
                .align(Alignment.Start),
                thickness = 3.5.dp,
                color = Color.Black)

            Spacer(modifier = Modifier.height(40.dp))
            DatoAleatorioSlide(dato = datosVideoJuegos[index], direccion = direccion,
                onSwipeLeft = {
                    direccion = 1
                    index = datosVideoJuegos.indices.random()
                }, onSwipeRight = {
                    direccion = -1
                    index = datosVideoJuegos.indices.random()
                })
            Spacer(modifier = Modifier.height(45.dp))

            HorizontalDivider(modifier = Modifier
                .height(5.dp)
                .width(230.dp)
                .align(Alignment.End),
                thickness = 3.5.dp, color = Color.Black)

            BotonesNavAcciones(
                onAnteriorClick = {direccion = -1
                    index = datosVideoJuegos.indices.random()},
                onSiguienteClick = {direccion = 1
                    index = datosVideoJuegos.indices.random()},
                onFavoritoClick = {viewModel.cambiarFavorito(textoActual)},
                onCompartirClick = {},
                esFavorito = esFavorito)
        }
    }
}

@Preview(showBackground = true, apiLevel = 34)
@Composable
fun PreviewCategoriaVideoJ() {
    CategoriaVideoJ()
}