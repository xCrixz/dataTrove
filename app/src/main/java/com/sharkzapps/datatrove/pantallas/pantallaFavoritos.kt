package com.sharkzapps.datatrove.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun PantallaFavoritos(navController: NavController, favViewModel: DataTroveViewModel){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFFFF8E1),
                    Color(0xFFFFE082)
                )
            )
        )){
        Column(modifier = Modifier.fillMaxSize().padding(14.dp, 8.dp)) {

            val controller = navController ?: rememberNavController()
            Encabezado(navController = controller, onMenuClick = {})
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

            Spacer(modifier = Modifier.height(20.dp))

            if (favViewModel.favoritos.isEmpty()){
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
                LazyColumn {
                    items(favViewModel.favoritos){ item -> Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = item,
                                fontSize = 22.sp,
                                fontFamily = garamondFamily,
                                modifier = Modifier.weight(1f)
                            )

                            IconButton(onClick = { favViewModel.cambiarFavorito(item) }) {
                                Icon(imageVector = Icons.Default.Favorite,
                                    contentDescription = "Quitar", tint = Color.Red )
                            }
                        }
                    }}
                }
            }
        }
    }
    
}

@Preview
@Composable
fun PreviewFavoritos(){

}