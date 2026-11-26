package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.TodoItem
import com.example.myapplication.domain.repository.FakeTodoRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetTodosUseCaseTest {

    @Test
    fun `GetTodosUseCase returns three tasks`() = runBlocking {
        val todos = listOf(
            TodoItem(
                id = 1,
                title = "Задача 1",
                description = "Описание 1",
                isCompleted = false
            ),
            TodoItem(
                id = 2,
                title = "Задача 2",
                description = "Описание 2",
                isCompleted = true
            ),
            TodoItem(
                id = 3,
                title = "Задача 3",
                description = "Описание 3",
                isCompleted = false
            )
        )

        val repository = FakeTodoRepository(todos)
        val useCase = GetTodosUseCase(repository)

        val result = useCase()

        assertEquals(3, result.size)
        assertEquals(todos, result)
    }
}