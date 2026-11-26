package com.example.myapplication.presentation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.myapplication.domain.model.TodoItem

@Composable
fun TodoDetailScreen(
    todo: TodoItem,
    onBackClick: () -> Unit
) {
    Column {
        Text(text = todo.title)
        Text(text = todo.description)

        Text(
            text = if (todo.isCompleted) {
                "Статус: выполнена"
            } else {
                "Статус: не выполнена"
            }
        )

        Button(
            onClick = onBackClick
        ) {
            Text(text = "Назад")
        }
    }
}