package com.adversegecko3.twittergeckoui.model

data class Trend(
    val type: String,
    val title: String,
    val quantity: Int,
    val image: TrendImage? = null
)

data class TrendImage(
    val imageType: Int,
    val image: Int
)
