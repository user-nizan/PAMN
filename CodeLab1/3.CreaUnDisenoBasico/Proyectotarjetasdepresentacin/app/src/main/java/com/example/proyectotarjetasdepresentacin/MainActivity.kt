package com.example.proyectotarjetasdepresentacin

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectotarjetasdepresentacin.ui.theme.ProyectoTarjetasDePresentaciónTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoTarjetasDePresentaciónTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Contenido()
                    ColumnaIconoYContenido()                }
            }
        }
    }
}

@Composable
fun IconoYContenido(image : Int, mensaje : String, modifier: Modifier = Modifier) {
    Row {
        Image(painter = painterResource(id = image), contentDescription = null)
        Text(
            text = mensaje,
            style = TextStyle(fontSize = 14.sp),
            modifier = modifier
        )
    }
}
@Composable
fun ColumnaIconoYContenido(){
    Column(
        modifier = Modifier.fillMaxSize().padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        IconoYContenido(image = R.drawable.baseline_local_phone_24, mensaje = "+34 123456789")
        IconoYContenido(image = R.drawable.baseline_share_24, mensaje = "@androideveloper")
        IconoYContenido(image = R.drawable.baseline_mail_24, mensaje = "nizan@developer")
    }
}

@Composable
fun Contenido(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(id = R.drawable.salon___img_0007),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = "Nizan Díaz",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
        )
        Text(text = "Android Developer Extraordinaire",
            style = TextStyle(fontSize = 20.sp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoTarjetasDePresentaciónTheme {
        Contenido()
        ColumnaIconoYContenido()
    }
}