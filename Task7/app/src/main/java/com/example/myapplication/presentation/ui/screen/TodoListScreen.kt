package com.example.myapplication.presentation.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.myapplication.domain.model.TodoItem
import com.example.myapplication.presentation.ui.component.TodoItemRow

@Composable
fun TodoListScreen(
    todos: List<TodoItem>,
    onTodoClick: (Int) -> Unit,
    onToggleTodo: (Int) -> Unit
) {
    LazyColumn {
        items(
            items = todos,
            key = { it.id }
        ) { todo ->
            TodoItemRow(
                todo = todo,
                onClick = {
                    onTodoClick(todo.id)
                },
                onToggle = {
                    onToggleTodo(todo.id)
                }
            )
        }
    }
}