package com.adversegecko3.twittergeckoui

import kotlin.math.roundToInt

fun Int.reformatNumbers(): String {
    return when {
        this >= 1_000_000 -> {
            "${((this.toDouble() / 1_000_000) * 10.0).roundToInt() / 10.00} M"
        }
        this >= 1_000 -> {
            "${((this.toDouble() / 1_000) * 10.0).roundToInt() / 10.00} K"
        }
        else -> {
            this.toString()
        }
    }
}