package com.example.myapplication.ui.adaptive

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

data class CardItem(
    @DrawableRes val imageResource: Int,
    val title: String,
    val description: String
)

val cardList = listOf(
    CardItem(R.drawable.travel, "Путешествия", "Новые места и интересные маршруты."),
    CardItem(R.drawable.music, "Музыка", "Подборки для учёбы и отдыха."),
    CardItem(R.drawable.books, "Книги", "Произведения, которые стоит прочитать."),
    CardItem(R.drawable.sport, "Спорт", "Тренировки и полезные привычки."),
    CardItem(R.drawable.cinema, "Кино", "Фильмы для вечернего просмотра."),
    CardItem(R.drawable.photography, "Фотография", "Идеи и советы для красивых снимков.")
)

@Composable
fun AdaptiveApp(
    windowWidthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableStateOf(cardList.first()) }

    when (windowWidthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            ItemList(
                items = cardList,
                onItemClick = { },
                modifier = modifier
            )
        }

        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded -> {
            Row(modifier = modifier.fillMaxSize()) {
                ItemList(
                    items = cardList,
                    onItemClick = { selectedItem = it },
                    modifier = Modifier.weight(1f)
                )
                ItemDetails(
                    item = selectedItem,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        else -> {
            ItemList(
                items = cardList,
                onItemClick = { },
                modifier = modifier
            )
        }
    }
}

@Composable
fun ItemList(
    items: List<CardItem>,
    onItemClick: (CardItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items = items) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 6.dp)
                    .clickable { onItemClick(item) }
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = item.imageResource),
                        contentDescription = item.title,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(MaterialTheme.shapes.small),
                        contentScale = ContentScale.Crop
                    )

                    Column(modifier = Modifier.padding(start = 12.dp)) {
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

@Composable
fun ItemDetails(
    item: CardItem,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = item.imageResource),
            contentDescription = item.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )

        Text(
            text = item.title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = item.description,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
