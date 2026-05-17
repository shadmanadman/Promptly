package org.kmp.playground.promptly

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform