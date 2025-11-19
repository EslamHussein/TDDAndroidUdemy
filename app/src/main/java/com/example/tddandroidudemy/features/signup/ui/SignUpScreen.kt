package com.example.tddandroidudemy.features.signup.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tddandroidudemy.R
import com.example.tddandroidudemy.features.signup.vm.SignUpState
import com.example.tddandroidudemy.ui.theme.TDDAndroidUdemyTheme

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    state: SignUpState,
    onSignUpClick: (email: String, password: String) -> Unit
) {


    Scaffold(modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
        ) {

            Text("Create an account", style = MaterialTheme.typography.displaySmall)

            OutlinedTextField(
                value = state.email,
                onValueChange = {},
                label = {
                    Text(stringResource(R.string.email_hint))
                }
            )


            PasswordTextField(
                password = state.password,
                onValueChange = {

                }
            )

            Button(onClick = {}) {
                Text(stringResource(R.string.sign_up_button_text))
            }

        }


    }

}

@Composable
private fun PasswordTextField(
    modifier: Modifier = Modifier,
    password: String,
    onValueChange: (String) -> Unit
) {

    var passwordIsVisible by remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = modifier,
        value = password,
        onValueChange = onValueChange,
        label = {
            Text(stringResource(R.string.password_hint))
        },
        trailingIcon = {

            Icon(
                modifier = Modifier.clickable {
                    passwordIsVisible = !passwordIsVisible
                },
                imageVector = if (passwordIsVisible) Icons.Default.RemoveRedEye else Icons.Default.VisibilityOff,
                contentDescription = "show password"
            )
        },
        visualTransformation = if (passwordIsVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}


@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {

    TDDAndroidUdemyTheme {
        SignUpScreen(
            modifier = Modifier,
            state = SignUpState(email = "eslam.asd@gmail.com", password = "P@\$sw0rd"),
            onSignUpClick = { email, password ->

            }
        )

    }

}
