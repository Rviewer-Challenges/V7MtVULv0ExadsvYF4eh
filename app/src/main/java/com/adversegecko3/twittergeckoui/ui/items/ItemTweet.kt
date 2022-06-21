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
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adversegecko3.twittergeckoui.R
import com.adversegecko3.twittergeckoui.model.Tweet
import com.adversegecko3.twittergeckoui.model.TweetTopInfo
import com.adversegecko3.twittergeckoui.model.User
import com.adversegecko3.twittergeckoui.reformatNumbers
import com.adversegecko3.twittergeckoui.ui.theme.TwitterGray

@Composable
fun ItemTweet(
    tweet: Tweet
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Column {
            if (tweet.topInfo != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = tweet.topInfo.icon),
                        contentDescription = "Tweet Icon",
                        modifier = Modifier
                            .padding(start = 52.dp)
                            .size(16.dp),
                        tint = TwitterGray
                    )
                    Text(
                        text = tweet.topInfo.text,
                        modifier = Modifier.padding(start = 8.dp),
                        color = TwitterGray,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
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
                            .height(IntrinsicSize.Max)
                            .fillMaxWidth()
                            .padding(bottom = 2.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = tweet.user.userName,
                            modifier = Modifier.padding(start = 8.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "@${tweet.user.userHandle}",
                            color = TwitterGray,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                        Text(
                            text = "·",
                            color = TwitterGray,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                        Text(
                            text = calculateDate(tweet.timeAgo),
                            color = TwitterGray,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Outlined.MoreVert,
                            contentDescription = "Dots",
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .layout { measurable, constraints ->
                                    if (constraints.maxHeight == Constraints.Infinity) {
                                        layout(0, 0) {}
                                    } else {
                                        val placeable = measurable.measure(constraints)
                                        layout(placeable.width, placeable.height) {
                                            placeable.place(0, 0)
                                        }
                                    }
                                }
                        )
                    }
                    Text(
                        text = tweet.content,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                    )
                    Row(
                        modifier = Modifier
                            .height(36.dp)
                            .padding(top = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .weight(1f),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            IconButton(
                                onClick = { }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 8.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_comment),
                                        contentDescription = "Icon Comment",
                                        modifier = Modifier
                                            .padding(vertical = 8.dp)
                                            .align(Alignment.CenterVertically),
                                        tint = TwitterGray
                                    )
                                    Text(
                                        text = tweet.numComments.reformatNumbers(),
                                        fontSize = 12.sp,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .padding(start = 8.dp)
                                            .align(Alignment.CenterVertically),
                                        color = TwitterGray
                                    )
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            IconButton(
                                onClick = { }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 8.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_retweet),
                                        contentDescription = "Icon Retweet",
                                        modifier = Modifier
                                            .padding(vertical = 8.dp)
                                            .align(Alignment.CenterVertically),
                                        tint = TwitterGray
                                    )
                                    Text(
                                        text = tweet.numRetweets.reformatNumbers(),
                                        fontSize = 12.sp,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .padding(start = 8.dp)
                                            .align(Alignment.CenterVertically),
                                        color = TwitterGray
                                    )
                                }

                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            IconButton(
                                onClick = { }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 8.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_like_bordered),
                                        contentDescription = "Icon Like",
                                        modifier = Modifier
                                            .padding(vertical = 8.dp)
                                            .align(Alignment.CenterVertically),
                                        tint = TwitterGray
                                    )
                                    Text(
                                        text = tweet.numLikes.reformatNumbers(),
                                        fontSize = 12.sp,
                                        modifier = Modifier
                                            .padding(start = 8.dp)
                                            .align(Alignment.CenterVertically),
                                        color = TwitterGray
                                    )
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            IconButton(
                                onClick = { }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 8.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_share),
                                        contentDescription = "Icon Share",
                                        modifier = Modifier
                                            .padding(vertical = 8.dp)
                                            .align(Alignment.CenterVertically),
                                        tint = TwitterGray
                                    )
                                }
                            }
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
        user = User("IlloJuan", "LMDShow", R.drawable.profile_lmdshow),
        timeAgo = 2 * 60 * 60 * 1000,
        content = "Illo que man liao.\n\nAhora que viene el calorcito estoy más tiempo fuera de casa con los amigos " +
                "y quizá haga menos directos\n\nNO CE ME QUEJEI " +
                String(Character.toChars(0x1F621)) + String(Character.toChars(0x1F621)) +
                "\n\nEso si, mañana directo pasándonos Subnautica " +
                "y las secundarias de God of War " +
                String(Character.toChars(0x1F608)),
        numComments = 967,
        numRetweets = 2_567,
        numLikes = 59_637,
        topInfo = TweetTopInfo(
            icon = R.drawable.ic_nav_communities_selected,
            text = "IlloJuan City " + String(Character.toChars(0x1F1F3)) +
                    String(Character.toChars(0x1F1EC))
        )
    )
    ItemTweet(tweet = tweet)
}