package com.example.myapplication.ui.navigation

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.statusBarsPadding()
    ) {
        composable(route = "home") {
            HomeScreen(
                navController = navController
            )
        }

        composable(route = "details") {
            DetailsScreen()
        }
    }
}

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Button(
        onClick = {
            navController.navigate("details")
        }
    ) {
        Text(text = "Перейти на экран Details")
    }
}

@Composable
fun DetailsScreen() {
    Text(
        text = "Это экран Details. Здесь отображается подробная информация."
    )
}