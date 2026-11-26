package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myapplication.data.local.TodoJsonDataSource
import com.example.myapplication.data.repository.TodoRepositoryImpl
import com.example.myapplication.domain.usecase.GetTodosUseCase
import com.example.myapplication.domain.usecase.ToggleTodoUseCase
import com.example.myapplication.navigation.AppNavigation
import com.example.myapplication.presentation.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataSource = TodoJsonDataSource(
            applicationContext
        )

        val repository = TodoRepositoryImpl(
            dataSource
        )

        val getTodosUseCase = GetTodosUseCase(
            repository
        )

        val toggleTodoUseCase = ToggleTodoUseCase(
            repository
        )

        val viewModel = TodoViewModel(
            getTodosUseCase = getTodosUseCase,
            toggleTodoUseCase = toggleTodoUseCase
        )

        setContent {
            AppNavigation(
                viewModel = viewModel
            )
        }
    }
}