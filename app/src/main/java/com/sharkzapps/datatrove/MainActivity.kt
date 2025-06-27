package com.sharkzapps.datatrove

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sharkzapps.datatrove.pantallas.PantallaCarga
import com.sharkzapps.datatrove.pantallas.PantallaPrincipal
import com.sharkzapps.datatrove.ui.theme.DataTroveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DataTroveTheme {
                NavegacionApp()
            }
        }
    }
}

@Composable
fun NavegacionApp(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "pantallaCarga") {
        composable("pantallaCarga"){ PantallaCarga(navController)}
        composable("principal"){ PantallaPrincipal(navController)}

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}