package com.example.psihosamatickmobile.ui.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.psihosamatickmobile.ui.login.LoginScreen
import com.slapps.cupertino.theme.CupertinoTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.example.psihosamatickmobile.Platforms

var currentPlatform: Platforms = Platforms.ANDROID

@Composable
@Preview
fun App(platform: Platforms = Platforms.ANDROID) {
    currentPlatform = platform

    if (platform == Platforms.IOS) {
        CupertinoTheme {
            LoginScreen(useIOSStyle = true)
        }
    } else {
        MaterialTheme {
            LoginScreen(useIOSStyle = false)
        }
    }
}