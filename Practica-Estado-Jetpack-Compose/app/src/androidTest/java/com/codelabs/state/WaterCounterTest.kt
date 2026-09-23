package com.codelabs.state

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class WaterCounterTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun addOne_updatesCounter() {
        composeTestRule.setContent { StatefulCounter() }

        composeTestRule.onNodeWithText("Add one").performClick()
        composeTestRule.onNodeWithText("You've had 1 glasses.").assertIsDisplayed()
    }

    @Test
    fun counterStopsAtTen() {
        composeTestRule.setContent { StatefulCounter() }

        repeat(10) {
            composeTestRule.onNodeWithText("Add one").performClick()
        }

        composeTestRule.onNodeWithText("You've had 10 glasses.").assertIsDisplayed()
        composeTestRule.onNodeWithText("Add one").assertIsNotEnabled()
    }
}
