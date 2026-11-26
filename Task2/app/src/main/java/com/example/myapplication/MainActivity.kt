package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.AppTheme
import androidx.compose.foundation.lazy.items


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                ListSample(modifier = Modifier.statusBarsPadding())
            }
        }
    }
}

data class CardItem(
    @DrawableRes val imageResource: Int,
    val title: String,
    val description: String
)

val cardList = listOf(
    CardItem(
        imageResource = R.drawable.travel,
        title = "Путешествия",
        description = "Новые места и интересные маршруты."
    ),
    CardItem(
        imageResource = R.drawable.music,
        title = "Музыка",
        description = "Подборки для учёбы и отдыха."
    ),
    CardItem(
        imageResource = R.drawable.books,
        title = "Книги",
        description = "Произведения, которые стоит прочитать."
    ),
    CardItem(
        imageResource = R.drawable.sport,
        title = "Спорт",
        description = "Тренировки и полезные привычки."
    ),
    CardItem(
        imageResource = R.drawable.cinema,
        title = "Кино",
        description = "Фильмы для вечернего просмотра."
    ),
    CardItem(
        imageResource = R.drawable.photography,
        title = "Фотография",
        description = "Идеи и советы для красивых снимков."
    )
)

@Composable
fun ListSample(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(items = cardList) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp),
            ) {
                Row(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Image(
                        painter = painterResource(id = item.imageResource),
                        contentDescription = item.title,
                        modifier = Modifier
                            .size(96.dp)
                            .clip(MaterialTheme.shapes.small),
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = item.description,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }
        }
    }
}