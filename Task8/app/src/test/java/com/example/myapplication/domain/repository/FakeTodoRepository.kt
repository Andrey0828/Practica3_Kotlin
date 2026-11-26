package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.TodoItem

class FakeTodoRepository(
    initialTodos: List<TodoItem>
) : TodoRepository {

    private val todos = initialTodos.toMutableList()

    override suspend fun getTodos(): List<TodoItem> {
        return todos.toList()
    }

    override suspend fun toggleTodo(id: Int) {
        val index = todos.indexOfFirst { it.id == id }

        if (index != -1) {
            val todo = todos[index]

            todos[index] = todo.copy(
                isCompleted = !todo.isCompleted
            )
        }
    }
}