package com.hakka1.ithelp.example.eample.day4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.hakka1.ithelp.example.eample.day4.ui.theme.ExampleDay4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleDay4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    val isNeedExpansion = rememberSaveable { mutableStateOf(false) }
    val animatedSizeDp: Dp by animateDpAsState(targetValue = if (isNeedExpansion.value) 350.dp else 100.dp)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp)) {
        Card(
            elevation = 4.dp,
        ) {
            Image(painter = painterResource(id = R.drawable.moon),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("2022.9.10", color = Color.White, fontWeight = FontWeight.W700)
                Text("祝 $name 中秋節快樂~", color = Color.White, fontWeight = FontWeight.W700)
                Image(
                    painter = painterResource(R.drawable.rabbit),
                    contentDescription = "Rabbit Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(animatedSizeDp)
                        .clip(CircleShape)
                        .border(5.dp, Color.Gray, CircleShape)
                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable image",
                            onClick = {
                                isNeedExpansion.value = !isNeedExpansion.value
                            }
                        )
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExampleDay4Theme {
        Greeting("Android")
    }
}