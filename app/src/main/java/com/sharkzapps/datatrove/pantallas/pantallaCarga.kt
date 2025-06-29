package com.sharkzapps.datatrove.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import kotlinx.coroutines.delay

@Composable
fun PantallaCarga(navController: NavController? =null){
    LaunchedEffect(Unit) {
        navController?.let{
            delay(2000L)
            it.navigate("principal"){
                popUpTo("pantallaCarga") { inclusive = true}
            }
        }
    }

        Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color(0xFFFFFEE5)) {
                innerPadding -> Contenido(modifier = Modifier.padding(innerPadding))
        }
    }

@Composable
fun Contenido(modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(120.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "  Data \nTrove!", fontSize = 85.sp, style = TextStyle(
                    fontFamily = abrilFamily,
                    fontWeight = FontWeight.Normal
                ), lineHeight = 80.sp
            )
        }
        Spacer(modifier = Modifier.height(140.dp))
        CargaCircular()
    }
}

@Composable
fun CargaCircular(){
    var progreso by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(Unit) {
        while (progreso < 1f){
            delay(70L)
            progreso += 0.04f
        }
    }
    CircularProgressIndicator(
        progress = {progreso},
        modifier = Modifier.size(70.dp),
        color = Color.DarkGray
    )
}


@Preview(showBackground = true, apiLevel = 34)
@Composable
fun PreviewPantallaCarga(){
    PantallaCarga()
}