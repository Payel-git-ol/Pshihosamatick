package com.example.psihosamatickmobile.ui.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val isIOS = false

@Composable
fun LoginButton(
    text: String,
    onRegisterClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    useIOSStyle: Boolean = isIOS
) {
    Button(
        onClick = onRegisterClick,
        shape = RoundedCornerShape(if (useIOSStyle) 14.dp else 12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (useIOSStyle) Color(0xFF007AFF) else MaterialTheme.colorScheme.primary,
            contentColor = Color.White,
            disabledContainerColor = if (useIOSStyle) Color(0xFF007AFF).copy(alpha = 0.5f)
            else MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
            disabledContentColor = Color.White.copy(alpha = 0.5f)
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = if (useIOSStyle) 0.dp else 2.dp,
            pressedElevation = if (useIOSStyle) 0.dp else 4.dp
        ),
        enabled = enabled,
        modifier = modifier
            .height(if (useIOSStyle) 50.dp else 56.dp)
            .padding(horizontal = if (useIOSStyle) 20.dp else 40.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge.copy(
                fontSize = if (useIOSStyle) 17.sp else MaterialTheme.typography.labelLarge.fontSize,
                letterSpacing = if (useIOSStyle) 0.5.sp else MaterialTheme.typography.labelLarge.letterSpacing
            )
        )
    }
}