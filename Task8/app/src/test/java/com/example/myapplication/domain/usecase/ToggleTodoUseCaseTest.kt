package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.TodoItem
import com.example.myapplication.domain.repository.FakeTodoRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test

class ToggleTodoUseCaseTest {

    @Test
    fun `toggleTodo changes isCompleted`() = runBlocking {
        val repository = FakeTodoRepository(
            listOf(
                TodoItem(
                    id = 1,
                    title = "Задача",
                    description = "Описание",
                    isCompleted = false
                )
            )
        )

        val useCase = ToggleTodoUseCase(repository)

        useCase(1)

        assertTrue(
            repository.getTodos().first().isCompleted
        )
    }
}