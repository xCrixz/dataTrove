package com.sharkzapps.datatrove.pantallas

import android.annotation.SuppressLint
import android.content.Intent
import android.content.ActivityNotFoundException
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sharkzapps.datatrove.ui.theme.abrilFamily
import com.sharkzapps.datatrove.ui.theme.garamondFamily
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PantallaPrincipal(navController: NavController? = null){
        val controller = navController ?: rememberNavController()
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerContent = { ContenidoMenuLateral() },
            drawerState = drawerState
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFFFFEE5),
                                Color(0xFF81D4FA)
                            )
                        )
                    )
            ) {
                ZonaScrollable(onMenuClick = {
                    scope.launch { drawerState.open() } },
                    navController = controller
                    )
                FloatingActionButton(onClick = { /*TODO*/ }, containerColor = Color.Transparent,
                    elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(22.dp)){
                    Text(text = "\uD83C\uDFB2", fontSize = 32.sp)
                }
            }
        }
    }


    @Composable
fun ContenidoMenuLateral(){
    Column(modifier = Modifier
        .fillMaxHeight()
        .width(250.dp)
        .background(Color(0xFFFFFEE5))
        .padding(horizontal = 16.dp, vertical = 25.dp)) {
        Spacer(modifier = Modifier.size(25.dp))
        Opciones()
        Spacer(modifier = Modifier.size(20.dp))
        Soporte()
        Spacer(modifier = Modifier.size(20.dp))
        Siguenos()
        
        
    }
}

@Composable
fun Opciones(){
    Text(text = "\uD83D\uDCCB Opciones", fontSize = 30.sp, style = TextStyle(fontFamily = garamondFamily,
        fontWeight = FontWeight.Black))
    Spacer(modifier = Modifier.size(14.dp))
    Text(text = "Principal", fontSize = 22.sp, style = TextStyle(fontFamily = garamondFamily,
        fontWeight = FontWeight.ExtraBold), modifier = Modifier.clickable {  })
    Spacer(modifier = Modifier.size(14.dp))
    Text(text = "Notificaciones", fontSize = 22.sp, style = TextStyle(fontFamily = garamondFamily,
        fontWeight = FontWeight.ExtraBold), modifier = Modifier.clickable {  })
    Spacer(modifier = Modifier.size(14.dp))
    Text(text = "Favortitos", fontSize = 22.sp, style = TextStyle(fontFamily = garamondFamily,
        fontWeight = FontWeight.ExtraBold), modifier = Modifier.clickable {  })
    Spacer(modifier = Modifier.size(14.dp))
    Text(text = "Idiomas", fontSize = 22.sp, style = TextStyle(fontFamily = garamondFamily,
        fontWeight = FontWeight.ExtraBold), modifier = Modifier.clickable {  })
}

@SuppressLint("QueryPermissionsNeeded")
@Composable
fun Soporte(){
    val contexto = LocalContext.current
    Text(text = "\uD83D\uDEE0 Soporte", fontSize = 30.sp, style = TextStyle(fontFamily = garamondFamily,
        fontWeight = FontWeight.Black))
    Spacer(modifier = Modifier.size(14.dp))
    Text(text = "Reportar Errores", fontSize = 22.sp, style = TextStyle(fontFamily = garamondFamily,
        fontWeight = FontWeight.Black), modifier = Modifier.clickable {
        val subject = Uri.encode("Reporte de error")
        val body = Uri.encode(
            """
            Por favor completar:
            - Descripción del problema:
            """.trimIndent()
        )
        val uri = Uri.parse("mailto:sharkzapps@gmail.com?subject=$subject&body=$body")
        val intent = Intent(Intent.ACTION_SENDTO, uri)

        try {
            val chooser = Intent.createChooser(intent, "Enviar reporte con…")
            contexto.startActivity(chooser)
        } catch (e: ActivityNotFoundException) {
            Toast
                .makeText(
                    contexto,
                    "No hay apps de correo instaladas",
                    Toast.LENGTH_SHORT
                )
                .show()
        }
    })
    Spacer(modifier = Modifier.size(14.dp))
    Text(text = "Calificar app", fontSize = 22.sp, style = TextStyle(fontFamily = garamondFamily,
        fontWeight = FontWeight.Black), modifier = Modifier.clickable {  })
    Spacer(modifier = Modifier.size(14.dp))
    Text(text = "Ayuda", fontSize = 22.sp, style = TextStyle(fontFamily = garamondFamily,
        fontWeight = FontWeight.Black), modifier = Modifier.clickable {  })
}

@Composable
fun Siguenos(){
    val contexto = LocalContext.current
    Text(text = "\uD83C\uDF10 Síguenos", fontSize = 30.sp, style = TextStyle(fontFamily = garamondFamily,
        fontWeight = FontWeight.Black))
    Spacer(modifier = Modifier.size(14.dp))
    Text(text = "Instagram", fontSize = 22.sp, style = TextStyle(fontFamily = garamondFamily,
        fontWeight = FontWeight.Black), modifier = Modifier.clickable { val intent = Intent(Intent.ACTION_VIEW,
        Uri.parse("https://www.instagram.com/sharkzapps/"))
        contexto.startActivity(intent)})
    Spacer(modifier = Modifier.size(14.dp))
    Text(text = "Youtube", fontSize = 22.sp, style = TextStyle(fontFamily = garamondFamily,
        fontWeight = FontWeight.Black), modifier = Modifier.clickable { val intent = Intent(Intent.ACTION_VIEW,
        Uri.parse("https://www.youtube.com/channel/UCYsPCT3YmrOp4pEaod5W1xQ/posts?pvf=CAI%253D"))
        contexto.startActivity(intent)})
    Spacer(modifier = Modifier.size(14.dp))
    Text(text = "TikTok", fontSize = 22.sp, style = TextStyle(fontFamily = garamondFamily,
        fontWeight = FontWeight.Black), modifier = Modifier.clickable { val intent = Intent(Intent.ACTION_VIEW,
        Uri.parse("https://www.tiktok.com/@sharkzapps"))
        contexto.startActivity(intent)})
}



@Composable
fun Encabezado(navController: NavController, onMenuClick: () -> Unit){

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    var botonHabilitado by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(800)
        botonHabilitado = true

    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick =  {
                    if (!botonHabilitado) return@IconButton
                    if (currentRoute == "principal"){
                        onMenuClick()
                    } else { navController.popBackStack() }
                } ) {
                    val icon = if (currentRoute == "principal"){
                        Icons.Default.Menu
                    } else { Icons.Default.ArrowBack }

                    val descripcion = if (currentRoute == "principal") "Menu lateral" else "Volver atras"
                    Icon(imageVector = icon, contentDescription = descripcion, Modifier.size(40.dp)) }
            }

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
fun ZonaScrollable(onMenuClick: () -> Unit, navController: NavController?){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp)
    ) {
        item { Encabezado(navController = navController!!,onMenuClick = onMenuClick) }
        item { SeccionPopulares(navController!!) }
        item { SeccionCuriosos(navController!!) }
        item { SeccionLigeros(navController!!) }
        item { SeccionOtros(navController!!) }
    }
}

@Composable
fun SeccionPopulares(navController: NavController) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Populares ", fontSize = 35.sp, style = TextStyle(fontFamily = garamondFamily, fontWeight = FontWeight.Black))
            Text(text = "\uD83D\uDE0E", fontSize = 27.5.sp)
        }
        HorizontalDivider(
            modifier = Modifier
                .height(5.dp)
                .width(230.dp),
            thickness = 3.5.dp, color = Color.Black
        )
        Spacer(modifier = Modifier.height(30.dp))
        FlowRow(modifier = Modifier.padding(vertical = 15.dp, horizontal = 6.dp)) {
            TarjetaCategoria(texto = "Am   r", colorFondo = Color(0xFFFF6B81), emojiTexto = "❤\uFE0F", emojiSuperior = "\uD83D\uDCCD", DpOffset(13.2.dp, (3).dp), 14.sp, onClick = {navController.navigate("categoria_amor")})
            Spacer(modifier = Modifier.width(7.5.dp))
            TarjetaCategoria(texto = "Tecnología", colorFondo = Color(0xFF4D96FF), emojiTexto = "\uD83E\uDD16", emojiSuperior = "\uD83D\uDCCD", DpOffset(37.dp, (-48.5).dp), 26.sp, onClick = { navController.navigate("categoria_tecnologia") })
        }
        FlowRow(modifier = Modifier.padding(vertical = 15.dp, horizontal = 6.dp)) {
            TarjetaCategoria(texto = "Ciencia", colorFondo = Color(0xFF00B4D8), emojiTexto = "⚗\uFE0F", emojiSuperior = "\uD83D\uDCCD", DpOffset((-37).dp, (-47.5).dp), 26.sp, onClick = { navController.navigate("categoria_ciencia") })
            Spacer(modifier = Modifier.width(7.5.dp))
            TarjetaCategoria(texto = "Historia", colorFondo = Color(0xFFF4A261), emojiTexto = "\uD83D\uDCDC", emojiSuperior = "\uD83D\uDCCD", DpOffset((-67).dp, 30.dp), 26.sp, onClick = { navController.navigate("categoria_historia") })
        }
        FlowRow(modifier = Modifier.padding(vertical = 15.dp, horizontal = 6.dp)) {
            TarjetaCategoria(texto = "Animales", colorFondo = Color(0xFF8AC926), emojiTexto = "\uD83D\uDC36", emojiSuperior = "\uD83D\uDCCD", DpOffset((-12.25).dp, (-8.5).dp), 13.sp, onClick = { navController.navigate("categoria_animales") })
            Spacer(modifier = Modifier.width(7.5.dp))
            TarjetaCategoria(texto = "Psicología", colorFondo = Color(0xFF9D4EDD), emojiTexto = "\uD83E\uDDE0", emojiSuperior = "\uD83D\uDCCD", DpOffset(52.5.dp, (-19).dp), 22.sp, onClick = { navController.navigate("categoria_psicologia") })
        }
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp, horizontal = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            TarjetaCategoria(texto = "Cultura\nGeneral", colorFondo = Color(0xFF5C80BC), emojiTexto = "\uD83C\uDF0D", emojiSuperior = "\uD83D\uDCCD", DpOffset(62.dp, (-30).dp), 26.sp, onClick = { navController.navigate("categoria_cgeneral") })
        }
        Spacer(modifier = Modifier.size(30.dp))
    }
}

@Composable
fun SeccionCuriosos(navController: NavController) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Curiosos ", fontSize = 35.sp, style = TextStyle(fontFamily = garamondFamily, fontWeight = FontWeight.Black))
            Text(text = "\uD83E\uDDE0", fontSize = 27.5.sp)
        }
        HorizontalDivider(
            modifier = Modifier
                .height(5.dp)
                .width(230.dp),
            thickness = 3.5.dp, color = Color.Black
        )
        Spacer(modifier = Modifier.height(30.dp))
        FlowRow(modifier = Modifier.padding(vertical = 15.dp, horizontal = 6.dp)) {
            TarjetaCategoria(texto = "Arte", colorFondo = Color(0xFFE07A5F), emojiTexto = "\uD83C\uDFA8", emojiSuperior = "\uD83D\uDCCD", DpOffset((-65).dp, 32.dp), 26.sp, onClick = { navController.navigate("categoria_arte") })
            Spacer(modifier = Modifier.width(7.5.dp))
            TarjetaCategoria(texto = "Misterios", colorFondo = Color(0xFFD5C7BC), emojiTexto = "\uD83D\uDEF8", emojiSuperior = "\uD83D\uDCCD", DpOffset(45.dp, (-51).dp), 26.sp, onClick = { navController.navigate("categoria_misterios") })
        }
        FlowRow(modifier = Modifier.padding(vertical = 15.dp, horizontal = 6.dp)) {
            TarjetaCategoria(texto = "Idiomas", colorFondo = Color(0xFFFF9F1C), emojiTexto = "\uD83D\uDDE3\uFE0F", emojiSuperior = "\uD83D\uDCCD", DpOffset(69.dp, (-33).dp), 24.sp, onClick = { navController.navigate("categoria_idiomas") })
            Spacer(modifier = Modifier.width(7.5.dp))
            TarjetaCategoria(texto = "Espacio", colorFondo = Color(0xFF559AF0), emojiTexto = "\uD83D\uDE80", emojiSuperior = "\uD83D\uDCCD", DpOffset(50.dp, 17.dp), 26.sp, onClick = { navController.navigate("categoria_espacio") })
        }
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp, horizontal = 20.dp),
            horizontalArrangement = Arrangement.Center) {
            TarjetaCategoria(texto = "Inventos", colorFondo = Color(0xFFFFBE0B), emojiTexto = "\uD83D\uDD2C", emojiSuperior = "\uD83D\uDCCD", DpOffset(50.dp,20.dp ), 26.sp, onClick = { navController.navigate("categoria_inventos") })
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun SeccionLigeros(navController: NavController) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Ligeros ", fontSize = 35.sp, style = TextStyle(fontFamily = garamondFamily, fontWeight = FontWeight.Black))
            Text(text = "\uD83D\uDE02", fontSize = 27.5.sp) }
        HorizontalDivider(
            modifier = Modifier
                .height(5.dp)
                .width(230.dp),
            thickness = 3.5.dp, color = Color.Black)
        Spacer(modifier = Modifier.height(30.dp))
        FlowRow(modifier = Modifier.padding(vertical = 15.dp, horizontal = 6.dp)) {
            TarjetaCategoria(texto = "Videojuegos", colorFondo = Color(0xFFA92375), emojiTexto = "\uD83C\uDFAE", emojiSuperior = "\uD83D\uDCCD", DpOffset((-62).dp, (-29.5).dp), 26.sp, onClick = { navController.navigate("categoria_videoj") })
            Spacer(modifier = Modifier.width(7.5.dp))
            TarjetaCategoria(texto = "Comida", colorFondo = Color(0xFFE13B3B), emojiTexto = "\uD83C\uDF54", emojiSuperior = "\uD83D\uDCCD", DpOffset(65.5.dp, (-33.5).dp), 26.sp, onClick = { navController.navigate("categoria_comida") })
        }
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp, horizontal = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            TarjetaCategoria(texto = "Marcas", colorFondo = Color(0xFF3A86FF), emojiTexto = "\uD83D\uDC8E", emojiSuperior = "\uD83D\uDCCD", DpOffset(68.dp, (-29.5).dp), 26.sp, onClick = { navController.navigate("categoria_marcas") })
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun SeccionOtros(navController: NavController) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Otros ", fontSize = 35.sp, style = TextStyle(fontFamily = garamondFamily, fontWeight = FontWeight.Black))
            Text(text = "\uD83D\uDCC2", fontSize = 27.5.sp)
        }
        HorizontalDivider(
            modifier = Modifier
                .height(5.dp)
                .width(230.dp),
            thickness = 3.5.dp, color = Color.Black
        )
        Spacer(modifier = Modifier.height(30.dp))
        FlowRow(modifier = Modifier.padding(vertical = 15.dp, horizontal = 6.dp)) {
            TarjetaCategoria(texto = "Útiles", colorFondo = Color(0xFF2A9D8F), emojiTexto = "\uD83D\uDEE0\uFE0F", emojiSuperior = "\uD83D\uDCCD", DpOffset((-67).dp, (-33).dp), 26.sp, onClick = { navController.navigate("categoria_utiles") })
            Spacer(modifier = Modifier.width(7.5.dp))
            TarjetaCategoria(texto = "Divertidos", colorFondo = Color(0xFFF72585), emojiTexto = "\uD83E\uDD2A", emojiSuperior = "\uD83D\uDCCD", DpOffset((-64.5).dp, (-32).dp), 26.sp, onClick = { navController.navigate("categoria_divertidos") })
            Spacer(modifier = Modifier.size(30.dp))
        }
        Spacer(modifier = Modifier.size(50.dp))
    }
}

@Composable
fun TarjetaCategoria(
    texto: String,
    colorFondo: Color,
    emojiTexto: String,
    emojiSuperior: String,
    emojiTextoOffSet: DpOffset = DpOffset(4.dp, (-4).dp),
    sizeEmojiTexto: TextUnit = 22.sp,
    onClick: () -> Unit = {}

) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(140.dp)
            .height(70.dp)
            .clickable { onClick() }
    ) {
        // Caja base (tarjeta) con degradado
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(colorFondo.copy(alpha = 0.6f), colorFondo)
                    )
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = texto,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = garamondFamily,
                color = Color.Black
            )
        }

        // Emoji Reposicionado
        Text(text = emojiTexto, fontSize = sizeEmojiTexto,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(emojiTextoOffSet.x, emojiTextoOffSet.y))

        // Emoji superior flotando
        if (emojiSuperior.isNotEmpty()) {
            Text(
                text = emojiSuperior,
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .absoluteOffset(y = (-25.5).dp) // Lo sube visualmente sobre la tarjeta
                    .zIndex(1f)
            )
        }
    }
}

@Preview(showBackground = true, apiLevel = 34)
@Composable
fun PreviewPantallaPrincipal() {
    PantallaPrincipal()
}