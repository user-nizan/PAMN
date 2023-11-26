package com.example.randomproject

import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomproject.ui.theme.RandomProjectTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}


@Composable
fun ViewContainer(){
   Scaffold (content = { Content()})
}

@Preview
@Composable
fun ToolBar(){
    TopAppBar(title = { Text(text = "Aplicación de Nizan" , color = colorResource(R.color.white)) }, back)
}


@Composable
fun Content() {
    var contador by remember {mutableStateOf(0)}

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        item {


            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.wp5846045_travis_scott_desktop_2560x1440_wallpapers),
                contentDescription = "Logo de mi página"
            )
            Row {
                Image(painter = painterResource(id = R.drawable.ic_favorite), contentDescription = "like", modifier = Modifier.clickable {contador++})
                Text(text = contador.toString(), color = Color.White)
            }

            Text(
                text = "Buenas, soy Nizan",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Esta es mi primera APP",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Espero que os guste!!",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                item {
                    Text(text = "Se los siguientes lenguajes: ", color = Color.White)
                    Text(text = "Java", color = Color.White)
                    Text(text = "SUSCRIBETE", color = Color.White)
                    Text(text = "SUSCRIBETE", color = Color.White)
                    Text(text = "SUSCRIBETE", color = Color.White)
                    Text(text = "SUSCRIBETE", color = Color.White)
                    Text(text = "SUSCRIBETE", color = Color.White)
                    Text(text = "SUSCRIBETE", color = Color.White)
                    Text(text = "SUSCRIBETE", color = Color.White)
                }
            }
        }
    }
}
