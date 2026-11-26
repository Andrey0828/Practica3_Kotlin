package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.adaptive.AdaptiveApp
import com.example.myapplication.ui.navigation.AppNavigation
import com.example.myapplication.ui.theme.AppTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme() {
                val windowSize = calculateWindowSizeClass(this)
                AdaptiveApp(
                    windowWidthSizeClass = windowSize.widthSizeClass,
                    modifier = Modifier.statusBarsPadding()
                )
            }
        }
    }
}