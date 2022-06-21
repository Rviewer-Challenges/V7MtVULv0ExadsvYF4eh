package com.adversegecko3.twittergeckoui.model

data class Tweet(
    val user: User,
    val timeAgo: Long,
    val content: String,
    val numComments: Int,
    val numRetweets: Int,
    val numLikes: Int,
    val topInfo: TweetTopInfo? = null
)