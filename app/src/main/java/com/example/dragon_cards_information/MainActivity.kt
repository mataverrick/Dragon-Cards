package com.example.dragon_cards_information

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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dragon_cards_information.data.DragonDataList
import com.example.dragon_cards_information.model.Dragon
import com.example.dragon_cards_information.ui.theme.Dragon_Cards_InformationTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dragon_Cards_InformationTheme {
                DragonApp()
            }
        }
    }
}

@Composable
fun DragonApp() {
    Surface(Modifier.fillMaxSize().safeDrawingPadding()) {
        DragonList(DragonDataList().loadDragonList(), modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun DragonHeader(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun DragonCard(dragon: Dragon, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.height(100.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(dragon.imageId),
                contentDescription = stringResource(dragon.stringNameId),
                modifier = Modifier
                    .weight(0.9f)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .weight(1.1f)
                    .fillMaxHeight()
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(dragon.stringNameId),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "I'm a dragon",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

}

@Composable
fun DragonList(dragonsList: List<Dragon>, modifier: Modifier = Modifier) {
    Column(modifier){
        DragonHeader(Modifier.fillMaxWidth().height(100.dp))
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Adaptive(170.dp)
        ) {
            repeat(15) {
                items(dragonsList) { dragon ->
                    DragonCard(
                        dragon,
                        Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun DragonAppPreview() {
    DragonList(DragonDataList().loadDragonList())
}

