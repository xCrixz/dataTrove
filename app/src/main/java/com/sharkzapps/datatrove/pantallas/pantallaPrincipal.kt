package com.sharkzapps.datatrove.pantallas

import androidx.compose.foundation.background
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sharkzapps.datatrove.ui.theme.abrilFamily
import com.sharkzapps.datatrove.ui.theme.garamondFamily

@Composable
fun PantallaPrincipal(navController: NavController? = null){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFFFFEE5)) // fondo claro
    ) {
        Encabezado()
        ZonaScrollable()
    }
}

@Composable
fun Encabezado(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "       Data  ✨\n     Trove!", fontSize = 50.sp, style = TextStyle
            (fontFamily = abrilFamily, fontWeight = FontWeight.Black), lineHeight = 42.5.sp)
        HorizontalDivider(modifier = Modifier
            .padding(vertical = 2.dp)
            .height(20.dp)
            .width(250.dp),
            thickness = 5.dp, color = Color.Black)
        HorizontalDivider(modifier = Modifier
            .height(20.dp)
            .width(200.dp),
            thickness = 5.dp, color = Color.Black)
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun ZonaScrollable(){


    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
    ) {
        item { Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Populares ", fontSize = 35.sp, style = TextStyle
                (fontFamily = garamondFamily, fontWeight = FontWeight.Black))
            
            Text(text = "\uD83D\uDE0E", fontSize = 27.5.sp)

        }
            HorizontalDivider(modifier = Modifier
                .height(5.dp)
                .width(230.dp),
                thickness = 3.5.dp, color = Color.Black)
            Spacer(modifier = Modifier.size(150.dp))}

        item { Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Curiosos ", fontSize = 35.sp, style = TextStyle
                    (fontFamily = garamondFamily, fontWeight = FontWeight.Black)
            )
            Text(text = "\uD83E\uDDE0", fontSize = 27.5.sp)
            }
            HorizontalDivider(modifier = Modifier
                .height(5.dp)
                .width(230.dp),
                thickness = 3.5.dp, color = Color.Black)

            Spacer(modifier = Modifier.size(150.dp))}

        item {Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Ligeros ", fontSize = 35.sp, style = TextStyle
                    (fontFamily = garamondFamily, fontWeight = FontWeight.Black)
            )
            Text(text = "\uD83D\uDE02", fontSize = 27.5.sp)
            }

            HorizontalDivider(modifier = Modifier
                .height(5.dp)
                .width(230.dp),
                thickness = 3.5.dp, color = Color.Black)

            Spacer(modifier = Modifier.size(150.dp))}

        item { Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Otros ", fontSize = 35.sp, style = TextStyle
                    (fontFamily = garamondFamily, fontWeight = FontWeight.Black)
            )
            Text(text = "\uD83D\uDCC2", fontSize = 27.5.sp)
            }
            HorizontalDivider(modifier = Modifier
                .height(5.dp)
                .width(230.dp),
                thickness = 3.5.dp, color = Color.Black)
            Spacer(modifier = Modifier.size(150.dp))}

    }
}

@Preview(showBackground = true, apiLevel = 34)
@Composable
fun PreviewPantallaPrincipal() {
    PantallaPrincipal()
}