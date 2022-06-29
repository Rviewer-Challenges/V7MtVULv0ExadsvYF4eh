package com.adversegecko3.twittergeckoui.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adversegecko3.twittergeckoui.R
import com.adversegecko3.twittergeckoui.model.Notification
import com.adversegecko3.twittergeckoui.ui.theme.TwitterGray
import com.adversegecko3.twittergeckoui.ui.theme.TwitterLike
import com.adversegecko3.twittergeckoui.ui.theme.TwitterNotificationAndFollower
import com.adversegecko3.twittergeckoui.ui.theme.TwitterRetweet

@Composable
fun ItemNotification(
    notification: Notification
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Column {
            Row {
                NotificationActionIcon(notificationType = notification.type)
                Column(
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 4.dp)
                    ) {
                        val userProfilePhotos = notification.people.values.toList()
                        itemsIndexed(items = userProfilePhotos) { index, user ->
                            if (index < 8) {
                                Image(
                                    painter = painterResource(id = user),
                                    contentDescription = "User Profile Photo",
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .size(35.dp)
                                )
                                Spacer(modifier = Modifier.width(2.dp))
                            }
                        }
                    }
                    val userNames = notification.people.keys.toList()
                    var text = when (val userNamesSize = userNames.size) {
                        1 -> {
                            userNames[0]
                        }
                        2 -> {
                            "${userNames[0]} and ${userNames[1]} "
                        }
                        else -> {
                            "${userNames[0]}, ${userNames[1]} and ${userNamesSize - 2} more"
                        }
                    }
                    text = when (notification.type) {
                        0 -> {
                            "New tweet notifications for $text"
                        }
                        1 -> {
                            "$text followed you"
                        }
                        2 -> {
                            "$text liked"
                        }
                        else -> {
                            "$text retweeted"
                        }
                    }
                    if (notification.type != 0 && notification.type != 1) {
                        text = when (notification.actionType) {
                            0 -> {
                                "$text your tweet"
                            }
                            1 -> {
                                "$text your retweet"
                            }
                            2 -> {
                                "$text your reply"
                            }
                            else -> {
                                "$text a reply to your tweet"
                            }
                        }
                    }
                    Text(
                        text = text,
                        fontSize = 15.sp
                    )
                    if (notification.type != 0 && notification.type != 1) {
                        HyperlinkText(
                            fullText = notification.tweetContent!!,
                            linkText = notification.tweetContentLinkText!!,
                            hyperlinks = notification.tweetContentHyperlinks!!,
                            textColor = TwitterGray
                        )
                    }
                }
            }
            Divider(
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun NotificationActionIcon(notificationType: Int) {
    Icon(
        painter = when (notificationType) {
            0 -> {
                painterResource(id = R.drawable.ic_nav_notifications_selected)
            }
            1 -> {
                painterResource(id = R.drawable.ic_person)
            }
            2 -> {
                painterResource(id = R.drawable.ic_like_filled)
            }
            else -> {
                painterResource(id = R.drawable.ic_retweet)
            }
        },
        contentDescription = "Notification Icon",
        modifier = Modifier
            .padding(start = 41.dp)
            .size(27.dp),
        tint = when (notificationType) {
            0 -> {
                TwitterNotificationAndFollower
            }
            1 -> {
                TwitterNotificationAndFollower
            }
            2 -> {
                TwitterLike
            }
            else -> {
                TwitterRetweet
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewItemNotification() {
    val notification = Notification(
        type = 0,
        actionType = 1,
        tweetContent = "La verdad es Jetpack Compose no está nada mal",
        people = hashMapOf(
            "MoureDev" to R.drawable.profile_mouredev,
            "IlloJuan" to R.drawable.profile_lmdshow
        )
    )
    ItemNotification(notification = notification)
}