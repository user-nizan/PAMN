package com.example.art_space

import android.graphics.fonts.Font
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.art_space.ui.theme.Art_SpaceTheme
import androidx.compose.material3.TextButton
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Art_SpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun ArtApp() {
    var currentIndex by remember { mutableStateOf(0) }
    val arts = remember { listaDeCuadros() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {

        CreaciónCuadro(
            artPiece = arts[currentIndex],
            currentIndex = currentIndex,
            contador = arts.size,
            onIndexChange = { newIndex -> currentIndex = newIndex }
        )
    }
}


data class ContenidoCuadro(
    val imagen: Int,
    val titulo: String,
    val añoDeVenta: String,
    val añoDeCreacion: String
)


fun listaDeCuadros() = listOf(

    ContenidoCuadro(
        imagen = R.drawable.salvator_mundi,
        titulo = "1. Salvador Mundi, Leonardo da Vinci",
        añoDeVenta = "Se vendió en 2017 por 430 millones de dólares",
        añoDeCreacion = "Siglo XVI"
    ),
    ContenidoCuadro(
        imagen = R.drawable.willem_de_kooning,
        titulo = "2. Interchange, Willem de Kooning",
        añoDeVenta = "Se vendió en 2015 por 300 millones de dolares",
        añoDeCreacion = "Realizada 1955"
    ),
    ContenidoCuadro(
        imagen = R.drawable.nafea_faa_ipoipo,
        titulo = "2. Nafea Faa Ipoipo, Paul Gauguin",
        añoDeVenta = "Se vendió en 2015 por 300 millones de dolares",
        añoDeCreacion = "Realizada 1892"
    )
)

@Composable
fun Botones(currentIndex: Int, artworksCount: Int, onIndexChange: (Int) -> Unit) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        if (artworksCount > 1) {
            if (artworksCount > 1) {
                Image(painter = painterResource(id = R.drawable.baseline_arrow_back_24), contentDescription = "flecha atrás", modifier = Modifier.clickable { onIndexChange((currentIndex - 1 + artworksCount) % artworksCount) })
            }
            Image(painter = painterResource(id = R.drawable.baseline_arrow_forward_24), contentDescription = "flecha atrás", modifier = Modifier.clickable { onIndexChange((currentIndex + 1) % artworksCount) })
        }
    }
}

@Composable
fun ImagenCuadro(imageResource: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .background(color = Color.LightGray)
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}
@Composable
fun TextoCuadro(titulo: String, fontWeight: FontWeight? = null) {
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = titulo,
        textAlign = TextAlign.Center,
        fontWeight = fontWeight,
        color = Color.White,
        modifier = Modifier.fillMaxWidth(),
    )
}


@Composable
fun CreaciónCuadro(
    artPiece: ContenidoCuadro,
    currentIndex: Int,
    contador: Int,
    onIndexChange: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Estos son los 3 cuadros mas caros del mundo",
            modifier = Modifier.fillMaxWidth(),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        TextoCuadro(
            titulo = artPiece.titulo, fontWeight = FontWeight.Bold
        )
        TextoCuadro(titulo = artPiece.añoDeCreacion)
        TextoCuadro(titulo = artPiece.añoDeVenta)
        Spacer(modifier = Modifier.height(36.dp))
        ImagenCuadro(artPiece.imagen)
        Botones(currentIndex, contador, onIndexChange)

    }
}








