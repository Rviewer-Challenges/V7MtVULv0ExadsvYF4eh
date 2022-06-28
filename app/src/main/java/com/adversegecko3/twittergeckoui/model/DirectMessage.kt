package com.adversegecko3.twittergeckoui.model

data class DirectMessage(
    val user: User,
    val timeAgo: Long,
    val content: String
)