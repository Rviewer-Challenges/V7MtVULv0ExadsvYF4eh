package com.adversegecko3.twittergeckoui.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adversegecko3.twittergeckoui.R
import com.adversegecko3.twittergeckoui.model.Tweet
import com.adversegecko3.twittergeckoui.model.User
import com.adversegecko3.twittergeckoui.reformatNumbers

@Composable
fun ItemTweet(
    tweet: Tweet
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = tweet.user.userPhoto),
                contentDescription = "UserProfilePhoto",
                modifier = Modifier
                    .padding(start = 12.dp)
                    .size(56.dp)
                    .clip(CircleShape)
            )
            Column {
                Row(
                    modifier = Modifier
                        .padding(bottom = 2.dp)
                        .height(IntrinsicSize.Max)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = tweet.user.userName,
                        modifier = Modifier.padding(start = 8.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "@${tweet.user.userHandle}",
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                    Text(
                        text = "·",
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                    Text(
                        text = calculateDate(tweet.timeAgo),
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Outlined.MoreVert,
                        contentDescription = "Dots",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
                Text(
                    text = tweet.content,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                )
                Row(
                    modifier = Modifier
                        .height(36.dp)
                        .padding(top = 4.dp)
                ) {
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_comment),
                                contentDescription = "Icon Comment",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .wrapContentHeight()
                                    .align(Alignment.CenterVertically)
                            )
                            Text(
                                text = tweet.numComments.reformatNumbers(),
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    }
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_retweet),
                                contentDescription = "Icon Retweet",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .wrapContentHeight()
                                    .align(Alignment.CenterVertically)
                            )
                            Text(
                                text = tweet.numRetweets.reformatNumbers(),
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .align(Alignment.CenterVertically)
                            )
                        }

                    }
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_like_bordered),
                                contentDescription = "Icon Like",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .wrapContentHeight()
                                    .align(Alignment.CenterVertically)
                            )
                            Text(
                                text = tweet.numLikes.reformatNumbers(),
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    }
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_share),
                                contentDescription = "Icon Share",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .wrapContentHeight()
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    }
                }
            }
        }
    }
    Divider()
}

private fun calculateDate(timeAgo: Long): String {
    return when {
        timeAgo < 60 * 1000 -> {
            "${timeAgo / 1000}s"
        }
        timeAgo < 60 * 60 * 1000 -> {
            "${timeAgo / (60 * 1000)}m"
        }
        timeAgo < 24 * 60 * 60 * 1000 -> {
            "${timeAgo / (60 * 60 * 1000)}h"
        }
        else -> {
            "${timeAgo / (24 * 60 * 60 * 1000)}d"
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemTweet() {
    val tweet = Tweet(
        user = User("AdverseGecko3", "adversegecko3", R.drawable.profile_adversegecko3),
        timeAgo = 24 * 60 * 60 * 1000,
        content = "Hello, world!" +
                "\nI'm AdverseGecko3 and TwitterGeckoUI is AWESOME!" +
                "\n\nSee ya!",
        numComments = 2,
        numRetweets = 0,
        numLikes = 6
    )
    ItemTweet(tweet = tweet)
}