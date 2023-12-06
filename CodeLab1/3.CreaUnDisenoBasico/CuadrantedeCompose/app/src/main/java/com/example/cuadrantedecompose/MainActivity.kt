package com.example.cuadrantedecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cuadrantedecompose.ui.theme.CuadranteDeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadranteDeComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CuadranteGeneral()
                }
            }
        }
    }
}

@Composable
fun Cuadrante(titulo: String, texto : String,background: Color, modifier: Modifier) {
    Column(modifier = modifier
                .fillMaxSize()
                .background(background)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = titulo,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(12.dp)
        )
        Text(
            text = texto,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun CuadranteGeneral(){
    Column (Modifier.fillMaxWidth()){
        Row (Modifier.weight(1f)){
            Cuadrante(titulo = "Text composable", texto = "Displays text and follows the recommended Material Design guidelines.", background = Color.Red,modifier = Modifier.weight(1f)
            )
            Cuadrante(titulo = "Image composable", texto = "Creates a composable that lays out and draws a given Painter class object.", background = Color.Yellow,modifier= Modifier.weight(1f)
            )

        }
        Row(Modifier.weight(1f)) {
            Cuadrante(titulo = "Row composable", texto = "A layout composable that places its children in a horizontal sequence. b", background = Color.White, modifier =Modifier.weight(1f))
            Cuadrante(titulo = "Column composable", texto = "A layout composable that places its children in a vertical sequence.", background = Color.Green, modifier =Modifier.weight(1f))
        }
//
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CuadranteDeComposeTheme {
        CuadranteGeneral()
    }
}