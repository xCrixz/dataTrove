package com.sharkzapps.datatrove.pantallas.categorias

import android.graphics.Bitmap
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sharkzapps.datatrove.ui.theme.garamondFamily
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.sharkzapps.datatrove.pantallas.Encabezado
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sharkzapps.datatrove.pantallas.CategoriaState
import com.sharkzapps.datatrove.pantallas.FakeCategoriaState
import com.sharkzapps.datatrove.pantallas.datos.datosInventos

@Composable
fun CategoriaInventos(navController: NavController? = null,
                      state: CategoriaState
) {

    var index by remember { mutableIntStateOf(0) }
    var direccion by remember { mutableIntStateOf(1) }

    val textoActual = datosInventos[index]
    val esFavorito = state.esFavorito(textoActual)

    val context = LocalContext.current
    var bitmapParaCompartir by remember { mutableStateOf<Bitmap?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFFEE5),
                        Color(0xFFFFBE0B)
                    )
                )
            )
    ) {
        FraseCapturableInvisible(
            texto = textoActual,
            onBitmapReady = { bitmapParaCompartir = it }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp, 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val controller = navController ?: rememberNavController()
            Encabezado(navController = controller, onMenuClick = {})
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Inventos",
                fontSize = 35.sp,
                style = TextStyle(fontFamily = garamondFamily, fontWeight = FontWeight.Black),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            HorizontalDivider(modifier = Modifier
                .height(5.dp)
                .width(230.dp)
                .align(Alignment.Start),
                thickness = 3.5.dp, color = Color.Black)
            
            Spacer(modifier = Modifier.height(40.dp))
            DatoAleatorioSlide(dato = datosInventos[index], direccion = direccion,
                onSwipeLeft = {
                    direccion = 1
                    index = datosInventos.indices.random()
                }, onSwipeRight = {
                    direccion = -1
                    index = datosInventos.indices.random()
                })
            Spacer(modifier = Modifier.height(45.dp))

            HorizontalDivider(modifier = Modifier
                .height(5.dp)
                .width(230.dp)
                .align(Alignment.End),
                thickness = 3.5.dp, color = Color.Black)

            BotonesNavAcciones(
                onAnteriorClick = {direccion = -1
                    index = datosInventos.indices.random()},
                onSiguienteClick = {direccion = 1
                    index = datosInventos.indices.random()},
                onFavoritoClick = {state.cambiarFavorito(textoActual)},
                onCompartirClick = { bitmapParaCompartir?.let {
                    compartirImagen(context, it)
                } },
                esFavorito = esFavorito)
        }
    }
}


@Preview(showBackground = true, apiLevel = 34)
@Composable
fun PreviewCategoriaInventos() {
    CategoriaInventos(
        navController = rememberNavController(),
        state = FakeCategoriaState()
    )
}