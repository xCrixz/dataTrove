package com.sharkzapps.datatrove.pantallas

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sharkzapps.datatrove.ui.theme.garamondFamily
import kotlinx.coroutines.delay

@Composable
fun PantallaFavoritos(navController: NavController, state: CategoriaState){

    var confirmarEliminar by remember { mutableStateOf<String?>(null) }


    LaunchedEffect(confirmarEliminar) {
        if (confirmarEliminar != null){
            delay(2000)
            confirmarEliminar = null
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFFFF8E1),
                    Color(0xFFFFE082)
                )
            )
        ))
    {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(14.dp, 8.dp)) {

            Encabezado(navController = navController, onMenuClick = {})
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Favoritos ⭐",
                fontSize = 35.sp,
                style = TextStyle(fontFamily = garamondFamily, fontWeight = FontWeight.Black)
            )

            HorizontalDivider(modifier = Modifier
                .height(5.dp)
                .width(230.dp)
                .align(Alignment.Start),
                thickness = 3.5.dp, color = Color.Black)

            Spacer(modifier = Modifier.height(10.dp))

            if (state.favoritos.isEmpty()){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Aún no tienes favoritos",
                        fontSize = 22.sp,
                        color = Color.Gray,
                        fontFamily = garamondFamily
                    )
                }
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(bottom = 37.dp)) {
                    items(items =state.favoritos, key = {it} )
                    { item ->
                        val seleccionado = confirmarEliminar == item
                        val bordeColor by animateColorAsState(
                            targetValue = if(seleccionado) Color.Red else Color.Transparent,
                            label = "borde")

                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                            .animateItem(),
                        shape = RoundedCornerShape(12.dp), border = BorderStroke(
                            width = if (seleccionado) 4.dp else 0.dp, color = bordeColor
                        )
                    ) {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = item,
                                fontSize = 24.sp,
                                fontFamily = garamondFamily,
                                modifier = Modifier.weight(1f)
                            )

                            Icon(
                                imageVector = if (confirmarEliminar == item)
                                    Icons.Default.Delete else Icons.Default.Favorite,
                                contentDescription = "Quitar",
                                tint = Color.Red,
                                modifier = Modifier
                                    .size(25.dp)
                                    .clickable {
                                        if (confirmarEliminar == item) {
                                            state.cambiarFavorito(item)
                                            confirmarEliminar = null
                                        } else {
                                            confirmarEliminar = item
                                        }
                                    }

                            )

                        }
                    }}
                }
            }
        }
    }
}


@Preview(showBackground = true, apiLevel = 34)
@Composable
fun PreviewFavoritos() {
    PantallaFavoritos(navController = rememberNavController(), state = FakeCategoriaState() )
}
