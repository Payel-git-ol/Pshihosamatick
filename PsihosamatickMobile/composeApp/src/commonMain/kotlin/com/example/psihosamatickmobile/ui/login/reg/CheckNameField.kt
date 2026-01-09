package com.example.psihosamatickmobile.ui.login.reg

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true)
fun CheckNameField(
    name: String,
    onNameChange: (String) -> Unit,
    onClearClicked: () -> Unit,
    testName: String,
    modifier: Modifier = Modifier,
    useIOSStyle: Boolean = isIOS
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    OutlinedTextField(
        value = name,
        onValueChange = onNameChange,
        shape = RoundedCornerShape(if (useIOSStyle) 12.dp else 13.dp),
        textStyle = MaterialTheme.typography.bodyLarge.copy(
            fontSize = if (useIOSStyle) 17.sp else MaterialTheme.typography.bodyLarge.fontSize
        ),
        placeholder = {
            Text(
                text = testName,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Gray,
                    fontSize = if (useIOSStyle) 17.sp else MaterialTheme.typography.bodyLarge.fontSize
                ),
            )
        },
        singleLine = true,
        label = {
            Text(
                text = testName,
                style = MaterialTheme.typography.labelMedium.copy(
                    fontSize = if (useIOSStyle) 15.sp else MaterialTheme.typography.labelMedium.fontSize
                ),
                color = if (isFocused) {
                    if (useIOSStyle) Color(0xFF007AFF) else MaterialTheme.colorScheme.primary
                } else Color.Gray
            )
        },
        trailingIcon = {
            if (name.isNotEmpty()) {
                IconButton(
                    onClick = onClearClicked,
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear",
                        tint = if (useIOSStyle) Color(0xFF8E8E93) else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = if (useIOSStyle) Color(0xFF007AFF) else MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = if (useIOSStyle) Color(0xFFC7C7CC) else Color.Gray,
            focusedLabelColor = if (useIOSStyle) Color(0xFF007AFF) else MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = Color.Gray,
            cursorColor = if (useIOSStyle) Color(0xFF007AFF) else MaterialTheme.colorScheme.primary,
            focusedTextColor = if (useIOSStyle) Color.Black else MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = if (useIOSStyle) Color.Black else MaterialTheme.colorScheme.onSurface
        ),
        interactionSource = interactionSource,
        modifier = modifier
    )
}