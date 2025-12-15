package com.sharkzapps.datatrove

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sharkzapps.datatrove.pantallas.DataTroveViewModel
import com.sharkzapps.datatrove.pantallas.PantallaCarga
import com.sharkzapps.datatrove.pantallas.PantallaFavoritos
import com.sharkzapps.datatrove.pantallas.PantallaPrincipal
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaAmor
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaAnimales
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaArte
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaCiencia
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaComida
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaCGeneral
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaDivertidos
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaEspacio
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaHistoria
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaIdiomas
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaInventos
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaMarcas
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaMisterios
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaPsicologia
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaTecno
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaUtiles
import com.sharkzapps.datatrove.pantallas.categorias.CategoriaVideoJ
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
    val viewModel: DataTroveViewModel = viewModel()

    NavHost(navController = navController, startDestination = "pantallaCarga") {
        composable("pantallaCarga"){ PantallaCarga(navController)}
        composable("principal"){ PantallaPrincipal(navController)}

        // Pantalla Favoritos
        composable("favoritos"){ PantallaFavoritos(navController, viewModel) }

        // Pantallas de categorias
        composable("categoria_amor"){ CategoriaAmor(navController, viewModel) }
        composable("categoria_ciencia"){ CategoriaCiencia(navController, viewModel) }
        composable("categoria_tecnologia"){ CategoriaTecno(navController, viewModel) }
        composable("categoria_historia"){ CategoriaHistoria(navController, viewModel) }
        composable("categoria_animales"){ CategoriaAnimales(navController, viewModel) }
        composable("categoria_psicologia"){ CategoriaPsicologia(navController, viewModel) }
        composable("categoria_cgeneral"){ CategoriaCGeneral(navController, viewModel) }
        composable("categoria_arte"){ CategoriaArte(navController, viewModel) }
        composable("categoria_misterios"){ CategoriaMisterios(navController, viewModel) }
        composable("categoria_idiomas"){ CategoriaIdiomas(navController, viewModel) }
        composable("categoria_espacio"){ CategoriaEspacio(navController, viewModel) }
        composable("categoria_inventos"){ CategoriaInventos(navController, viewModel) }
        composable("categoria_videoj"){ CategoriaVideoJ(navController, viewModel) }
        composable("categoria_comida"){ CategoriaComida(navController, viewModel) }
        composable("categoria_marcas"){ CategoriaMarcas(navController, viewModel) }
        composable("categoria_utiles"){ CategoriaUtiles(navController, viewModel) }
        composable("categoria_divertidos"){ CategoriaDivertidos(navController, viewModel) }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}