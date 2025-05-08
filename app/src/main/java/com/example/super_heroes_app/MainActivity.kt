package com.example.super_heroes_app

import android.graphics.Paint
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.super_heroes_app.model.HeroesRepository

import com.example.super_heroes_app.ui.theme.SuperHeroAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Text(stringResource(R.string.app_name))
                            }
                        )
                    }
                ) { innerPadding ->
                    SuperHeroApp(modifier=Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun SuperHeroApp(modifier:Modifier=Modifier){
//    Column(modifier=modifier.fillMaxSize().padding(8.dp),
//        horizontalAlignment = Alignment.CenterHorizontally) {
//        HeroCard(modifier)
//        HeroCard(modifier)
//
//    }
    val herosData = HeroesRepository.heroes
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // general padding
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(herosData) { heroData ->
            HeroCard(

                heroNameCode = heroData.nameRes,
                heroDescriptionCode = heroData.descriptionRes,
                heroImageCode = heroData.imageRes
            )
        }
    }
}
@Composable
fun HeroCard(heroNameCode: Int, heroDescriptionCode: Int, heroImageCode: Int) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(72.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(72.dp)
            ) {
                Text(
                    text = stringResource(heroNameCode),
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = stringResource(heroDescriptionCode),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(heroImageCode),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(72.dp)
            )
        }
    }
}


//@Composable
//fun TopAppBar(title:String){
//    Row(modifier= Modifier, horizontalArrangement = Arrangement.Center){
//        Text(
//            text=title,
//            style = MaterialTheme.typography.displayLarge,
//            textAlign = TextAlign.Center
//        )
//    }
//}
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SuperHeroAppPreview() {
    SuperHeroAppTheme {
        Scaffold(
//            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(

                    title = {
                        Text("SuperHero-App")
                    }
                )
            }
        ) { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                color = MaterialTheme.colorScheme.background
            ) {
                SuperHeroApp()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SuperHeroAppPreviewDark() {
    SuperHeroAppTheme(darkTheme = true) {
        Scaffold(
//            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(

                    title = {
                        Text("SuperHero-App")
                    }
                )
            }

        ) { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                color = MaterialTheme.colorScheme.background
            ) {
                SuperHeroApp()
            }
        }
    }
}