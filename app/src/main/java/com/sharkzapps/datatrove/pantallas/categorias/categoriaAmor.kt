package com.sharkzapps.datatrove.pantallas.categorias

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sharkzapps.datatrove.pantallas.Encabezado
import com.sharkzapps.datatrove.pantallas.datos.datosAmor
import com.sharkzapps.datatrove.ui.theme.garamondFamily

@Composable
fun CategoriaAmor(navController: NavController? = null){

    var index by remember { mutableIntStateOf(0) }
    var direccion by remember { mutableIntStateOf(1) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFFFFEE5),
                    Color(0xFFFF6B81)
                )
            )
        )
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(14.dp, 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

                val controller = navController ?: rememberNavController()
                Encabezado(navController = controller, onMenuClick = {})

                Spacer(modifier = Modifier.height(5.dp))
            
                Text(
                    text = "Amor",
                    fontSize = 35.sp,
                    style = TextStyle(fontFamily = garamondFamily, fontWeight = FontWeight.Black),
                    modifier = Modifier.fillMaxWidth(),
                    // Alinear el texto a la izquierda
                    textAlign = TextAlign.Start
                )

                HorizontalDivider(modifier = Modifier
                    .height(5.dp)
                    .width(230.dp)
                    .align(Alignment.Start),
                    thickness = 3.5.dp, color = Color.Black)

                Spacer(modifier = Modifier.height(40.dp))

                DatoAleatorioSlide(dato = datosAmor[index], direccion = direccion,
                    onSwipeLeft = {
                        direccion = 1
                        index = datosAmor.indices.random()
                    }, onSwipeRight = {
                        direccion = -1
                        index = datosAmor.indices.random()
                    })

                Spacer(modifier = Modifier.height(45.dp))

                HorizontalDivider(modifier = Modifier
                    .height(5.dp)
                    .width(230.dp)
                    .align(Alignment.End),
                    thickness = 3.5.dp, color = Color.Black)

                BotonesNavAcciones(
                    onAnteriorClick = {direccion = -1
                        index = datosAmor.indices.random()},
                    onSiguienteClick = {direccion = 1
                        index = datosAmor.indices.random()},
                    onCompartirClick = {},
                    onFavoritoClick = {})
        }
    }
}

@Composable
fun DatoAleatorio(dato: String){
    Text(text = dato,
        fontSize = 30.sp, style = TextStyle(fontFamily = garamondFamily),
        color = Color.Black, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center
        , modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
    )
}

suspend fun PointerInputScope.detectHorizontalSwipe(
    onSwipeLeft: () -> Unit,
    onSwipeRight: () -> Unit
){
    var totalDx = 0f
    detectDragGestures(onDragStart = {
        totalDx = 0f
    },
        onDrag = {change, dragAmount ->
            val (dx, _) = dragAmount
            totalDx += dx
            change.consume()
        },
        onDragEnd = {
            when{
                totalDx < -80f -> onSwipeLeft()
                totalDx > 80f -> onSwipeRight()
            }
        })
}
@Composable
fun DatoAleatorioSlide(dato: String, direccion: Int, onSwipeLeft: () -> Unit, onSwipeRight: () -> Unit){
    Box(modifier = Modifier
        .fillMaxWidth()
        .pointerInput(Unit) {
            detectHorizontalSwipe(
                onSwipeLeft = onSwipeLeft,
                onSwipeRight = onSwipeRight
            )
        }) {
        AnimatedContent(targetState = dato, transitionSpec = {
            slideInHorizontally { fullWidth -> fullWidth * direccion } + fadeIn() togetherWith
            slideOutHorizontally { fullWidth -> -fullWidth * direccion } + fadeOut()
            }, label = ""
        ) { target ->
            Text(text = target,
                fontSize = 30.sp, style = TextStyle(fontFamily = garamondFamily),
                color = Color.Black, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center, modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth()
        )
    }}
}

@Composable
fun BotonesNavAcciones(onAnteriorClick: () -> Unit = {},
                       onSiguienteClick: () -> Unit = {},
                       onFavoritoClick: () -> Unit = {},
                       onCompartirClick: () -> Unit = {}){
    
    Spacer(modifier = Modifier.height(15.dp))
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(end = 20.dp), horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {

        Row {
            IconButton(onClick = onAnteriorClick, modifier = Modifier.size(60.dp)) {
                Icon(imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                    contentDescription = "Anterior", modifier = Modifier.size(55.dp) )
            }

            Spacer(modifier = Modifier.width(15.dp))
            IconButton(onClick = onSiguienteClick, modifier = Modifier.size(60.dp)) {
                Icon(imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                    contentDescription = "Siguiente", modifier = Modifier.size(55.dp) )
            }
        }

        Row {
            IconButton(onClick = onFavoritoClick) {
                Icon(imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorito", Modifier.size(40.dp) )
            }

            Spacer(modifier = Modifier.width(5.dp))

            IconButton(onClick = onCompartirClick) {
                Icon(imageVector = Icons.Default.Share,
                    contentDescription = "Compartir", Modifier.size(40.dp))
            }
        }
    }
}

@Preview(showBackground = true, apiLevel = 34)
@Composable
fun PreviewCategoriaAmor(){
    CategoriaAmor()
}
