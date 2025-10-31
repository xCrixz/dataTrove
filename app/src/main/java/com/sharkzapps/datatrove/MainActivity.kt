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
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaAmor
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaCiencia
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaTecno
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaHistoria
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaAnimales
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaPsicologia
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaCGeneral
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaArte
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaMisterios
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaIdiomas
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaEspacio
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaInventos
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaVideoJ
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaComida
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaMarcas
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaUtiles
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaDivertidos
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

        // Pantallas de categorias
        composable("categoria_amor"){ CategoriaAmor(navController) }
        composable("categoria_ciencia"){ CategoriaCiencia(navController) }
        composable("categoria_tecnologia"){ CategoriaTecno(navController) }
        composable("categoria_historia"){ CategoriaHistoria(navController) }
        composable("categoria_animales"){ CategoriaAnimales(navController) }
        composable("categoria_psicologia"){ CategoriaPsicologia(navController) }
        composable("categoria_cgeneral"){ CategoriaCGeneral(navController) }
        composable("categoria_arte"){ CategoriaArte(navController) }
        composable("categoria_misterios"){ CategoriaMisterios(navController) }
        composable("categoria_idiomas"){ CategoriaIdiomas(navController) }
        composable("categoria_espacio"){ CategoriaEspacio(navController) }
        composable("categoria_inventos"){ CategoriaInventos(navController) }
        composable("categoria_videoj"){ CategoriaVideoJ(navController) }
        composable("categoria_comida"){ CategoriaComida(navController) }
        composable("categoria_marcas"){ CategoriaMarcas(navController) }
        composable("categoria_utiles"){ CategoriaUtiles(navController) }
        composable("categoria_divertidos"){ CategoriaDivertidos(navController) }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}