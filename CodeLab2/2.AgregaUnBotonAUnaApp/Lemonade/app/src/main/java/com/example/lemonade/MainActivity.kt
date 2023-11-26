package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                AppLemon()
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CenterAlignedTopAppBar(
            title = { Text(text = "Lemonade creado por Nizan") },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Espero que hayas aprendido el procedimiento de como se exprime un limón", textAlign = TextAlign.Center, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(200.dp))
        Button(onClick = { result += 1 }) {
            when (result) {
                1 -> {
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = R.string.lemon_tree.toString()

                    )
                    Spacer(modifier = Modifier.height(32.dp))

                    Text(text = stringResource(R.string.lemon_tree_content))
                }

                2 -> {
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = R.string.lemon.toString()
                    )
                    Text(text = stringResource(R.string.lemon_content))

                }

                3 -> {
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = R.string.Glass_of_lemonade.toString()
                    )
                    Text(text = stringResource(R.string.Glass_of_lemonade_content))

                }

                4 -> {
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = R.string.Empty_glass.toString()
                    )
                    Text(text = stringResource(R.string.Empty_glass_content))

                }

                else -> result = 1

            }
            when (result) {
                1 -> println(R.string.lemon_tree_content)
                else -> println("")
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun AppLemon() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}