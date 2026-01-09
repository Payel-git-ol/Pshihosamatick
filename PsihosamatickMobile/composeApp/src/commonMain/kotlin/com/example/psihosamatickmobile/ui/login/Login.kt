package com.example.psihosamatickmobile.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.psihosamatickmobile.Validator
import com.example.psihosamatickmobile.ui.login.reg.CheckEmailField
import com.example.psihosamatickmobile.ui.login.reg.CheckNameField
import com.example.psihosamatickmobile.ui.login.reg.CheckPasswordField
import com.example.psihosamatickmobile.ui.login.reg.StudyAppHeader

@Composable
fun LoginScreen(
    useIOSStyle: Boolean
) {
    var userEmail by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }
    var isEmailFormatValid by remember { mutableStateOf(true) }

    val testEmail = "example@androidsprint.ru"
    val labelName = "Ivan"
    val labelPassword = "password"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(50.dp))
        StudyAppHeader(title = "Psihosamatick")
        Spacer(Modifier.height(120.dp))

        CheckEmailField(
            email = userEmail,
            isEmailValid = isEmailFormatValid,
            onEmailChange = { newValue ->
                userEmail = newValue
                isEmailFormatValid = newValue.isEmpty() || Validator.isValid(newValue)
            },
            onClearClicked = {
                userEmail = ""
                isEmailFormatValid = true
            },
            testEmail = testEmail,
            useIOSStyle = useIOSStyle
        )

        Spacer(Modifier.height(30.dp))

        CheckNameField(
            name = userName,
            onNameChange = { userName = it },
            onClearClicked = { userName = "" },
            testName = labelName,
            useIOSStyle = useIOSStyle
        )

        Spacer(Modifier.height(30.dp))

        CheckPasswordField(
            password = userPassword,
            onPasswordChange = { userPassword = it },
            onClearClicked = { userPassword = "" },
            testPassword = labelPassword,
            useIOSStyle = useIOSStyle
        )

        Spacer(Modifier.height(70.dp))

        LoginButton(
            text = "Регистрация",
            onRegisterClick = {
            },
            useIOSStyle = useIOSStyle,
        )
    }
}



