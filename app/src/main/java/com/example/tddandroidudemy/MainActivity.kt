package com.example.tddandroidudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.tddandroidudemy.features.signup.ui.SignUpScreen
import com.example.tddandroidudemy.features.signup.vm.SignUpState
import com.example.tddandroidudemy.ui.theme.TDDAndroidUdemyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TDDAndroidUdemyTheme {
                SignUpScreen(state = SignUpState()) { email, password ->

                }
            }
        }
    }
}