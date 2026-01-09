package com.example.psihosamatickmobile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

enum class Platforms {
    ANDROID,
    IOS,
    DESKTOP
}