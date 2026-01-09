package com.example.psihosamatickmobile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform