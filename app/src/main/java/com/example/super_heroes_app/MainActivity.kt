package com.example.super_heroes_app

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.super_heroes_app.ui.theme.SuperHeroAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SuperHeroApp(modifier=Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun SuperHeroApp(modifier:Modifier=Modifier){
    HeroCard(modifier)
}
@Composable
fun HeroCard(modifier: Modifier=Modifier){
    Row(modifier=modifier, horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Column{
            Text(
                text="Superhero McSuper Hero Face",
                style = MaterialTheme.typography.displayMedium,
            )
            Text(
                text="Is it a bird is it a plan? No its jetpack compose!",
                style = MaterialTheme.typography.bodyLarge


            )
        }
        var imageFile = painterResource(R.drawable.android_superhero1)
        Image(
            painter=imageFile,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}


//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Preview(showBackground = true)
@Composable
fun SuperHeroAppPreview() {
    SuperHeroAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            SuperHeroApp(modifier=Modifier.padding(innerPadding))
        }
    }
}