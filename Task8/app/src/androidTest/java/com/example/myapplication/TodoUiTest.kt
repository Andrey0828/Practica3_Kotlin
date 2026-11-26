package com.example.myapplication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.isToggleable
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TodoUiTest {

    @get:Rule
    val composeRule =
        createAndroidComposeRule<MainActivity>()

    @Before
    fun waitForTasks() {
        composeRule.waitUntil(
            timeoutMillis = 5_000
        ) {
            composeRule.onAllNodesWithText(
                "Купить молоко"
            ).fetchSemanticsNodes().isNotEmpty()
        }
    }

    @Test
    fun allThreeTasksFromJsonAreDisplayed() {
        composeRule.onNodeWithText(
            "Купить молоко"
        ).assertIsDisplayed()

        composeRule.onNodeWithText(
            "Позвонить маме"
        ).assertIsDisplayed()

        composeRule.onNodeWithText(
            "Сделать ДЗ по Android"
        ).assertIsDisplayed()
    }

    @Test
    fun checkboxChangesTaskStatus() {
        val checkbox = composeRule.onAllNodes(
            isToggleable()
        )[0]

        checkbox.assertIsOff()
        checkbox.performClick()
        checkbox.assertIsOn()
    }

    @Test
    fun navigationFromListToDetailAndBack() {
        composeRule.onNodeWithText(
            "Купить молоко"
        ).performClick()

        composeRule.onNodeWithText(
            "2 литра, обезжиренное"
        ).assertIsDisplayed()

        composeRule.onNodeWithText(
            "Назад"
        ).performClick()

        composeRule.onNodeWithText(
            "Купить молоко"
        ).assertIsDisplayed()
    }
}