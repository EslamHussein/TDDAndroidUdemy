package com.example.tddandroidudemy.signup

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.tddandroidudemy.MainActivity
import com.example.tddandroidudemy.R

fun launchSignUpScreen(
    signUpRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
    block: SignUpRobot.() -> Unit
): SignUpRobot {
    return SignUpRobot(signUpRule).apply(block)
}


class SignUpRobot(
    private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {
    fun typeEmail(email: String) {
        val emailHint = rule.activity.getString(R.string.email_hint)
        rule.onNodeWithText(emailHint)
            .performTextInput(email)

    }

    fun typePassword(password: String) {
        val passwordHint = rule.activity.getString(R.string.password_hint)
        rule.onNodeWithText(passwordHint)
            .performTextInput(password)

    }

    fun submit() {
        val signupButtonText = rule.activity.getString(R.string.sign_up_button_text)
        rule.onNodeWithText(signupButtonText)
            .performClick()
    }

    infix fun verify(block: SignUpVerification.() -> Unit): SignUpVerification {
        return SignUpVerification(rule).apply(block)
    }
}

class SignUpVerification(
    private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {

    fun timelineScreenIPresent() {
        val timeline = rule.activity.getString(R.string.timeline)
        rule.onNodeWithText(timeline)
            .assertIsDisplayed()
    }
}