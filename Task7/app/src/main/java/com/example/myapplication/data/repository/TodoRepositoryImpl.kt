package com.example.myapplication.data.repository

import com.example.myapplication.data.local.TodoJsonDataSource
import com.example.myapplication.data.model.TodoItemDto
import com.example.myapplication.domain.model.TodoItem
import com.example.myapplication.domain.repository.TodoRepository

class TodoRepositoryImpl(
    private val dataSource: TodoJsonDataSource
) : TodoRepository {

    private var cachedTodos: MutableList<TodoItemDto>? = null

    override suspend fun getTodos(): List<TodoItem> {
        return getCachedTodos().map { dto ->
            TodoItem(
                id = dto.id,
                title = dto.title,
                description = dto.description,
                isCompleted = dto.isCompleted
            )
        }
    }

    override suspend fun toggleTodo(id: Int) {
        val todos = getCachedTodos()
        val index = todos.indexOfFirst { it.id == id }

        if (index != -1) {
            val todo = todos[index]

            todos[index] = todo.copy(
                isCompleted = !todo.isCompleted
            )
        }
    }

    private fun getCachedTodos(): MutableList<TodoItemDto> {
        return cachedTodos ?: dataSource.getTodos()
            .toMutableList()
            .also { cachedTodos = it }
    }
}