package com.adversegecko3.twittergeckoui.model

import androidx.compose.ui.graphics.Color

data class Space(
    val title: String,
    val listeners: Int,
    val host: String,
    val description: String,
    val alColors: ArrayList<Color>
)
