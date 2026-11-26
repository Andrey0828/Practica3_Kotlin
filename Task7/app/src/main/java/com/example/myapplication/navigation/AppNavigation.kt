package com.example.myapplication.navigation

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.presentation.ui.screen.TodoDetailScreen
import com.example.myapplication.presentation.ui.screen.TodoListScreen
import com.example.myapplication.presentation.viewmodel.TodoViewModel

@Composable
fun AppNavigation(
    viewModel: TodoViewModel
) {
    val navController = rememberNavController()
    val todos by viewModel.todos.collectAsState()

    NavHost(
        navController = navController,
        startDestination = "todoList",
        modifier = Modifier.statusBarsPadding()
    ) {
        composable(route = "todoList") {
            TodoListScreen(
                todos = todos,
                onTodoClick = { id ->
                    navController.navigate("todoDetail/$id")
                },
                onToggleTodo = viewModel::toggleTodo
            )
        }

        composable(
            route = "todoDetail/{todoId}",
            arguments = listOf(
                navArgument("todoId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val todoId =
                backStackEntry.arguments?.getInt("todoId")

            val todo = todos.find { it.id == todoId }

            if (todo != null) {
                TodoDetailScreen(
                    todo = todo,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}