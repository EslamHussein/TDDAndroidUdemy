package com.example.tddandroidudemy.signup

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.tddandroidudemy.MainActivity
import org.junit.Rule
import org.junit.Test

class SignUpTest {


    @get:Rule
    val signUpRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun performSignUp() {

        launchSignUpScreen(signUpRule) {
            typeEmail("es@es.com")
            typePassword("eseses")
            submit()
        } verify {
            timelineScreenIPresent()
        }
    }


}