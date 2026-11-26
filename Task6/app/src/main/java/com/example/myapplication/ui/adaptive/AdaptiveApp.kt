package com.example.myapplication.ui.adaptive

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AdaptiveApp(
    windowWidthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    when (windowWidthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Column(
                modifier = modifier
            ) {
                Text(text = "Одна колонка")
                Text(text = "Элемент 1")
                Text(text = "Элемент 2")
                Text(text = "Элемент 3")
            }
        }

        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded -> {
            Row(
                modifier = modifier
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Список")
                    Text(text = "Элемент 1")
                    Text(text = "Элемент 2")
                    Text(text = "Элемент 3")
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Детали")
                    Text(
                        text = "Здесь отображается подробная информация."
                    )
                }
            }
        }

        else -> {
            Column(
                modifier = modifier
            ) {
                Text(text = "Одна колонка")
                Text(text = "Элемент 1")
                Text(text = "Элемент 2")
                Text(text = "Элемент 3")
            }
        }
    }
}