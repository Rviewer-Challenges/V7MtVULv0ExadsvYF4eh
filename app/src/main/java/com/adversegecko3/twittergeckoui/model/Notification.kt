package com.adversegecko3.twittergeckoui.model

data class Notification(
    /*
    0: Tweet Notification
    1: Follower
    2: Like
    3: Retweet
     */
    val type: Int,
    /*
    0: Tweet
    1: Retweet
    2: Reply
    3: A reply to your tweet
     */
    val actionType: Int = 0,
    val tweetContent: String? = null,
    val tweetContentLinkText: List<String>? = null,
    val tweetContentHyperlinks: List<String>? = null,
    val people: HashMap<String, Int>
)