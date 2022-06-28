package com.adversegecko3.twittergeckoui.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adversegecko3.twittergeckoui.R
import com.adversegecko3.twittergeckoui.model.DirectMessage
import com.adversegecko3.twittergeckoui.model.User
import com.adversegecko3.twittergeckoui.ui.theme.TwitterGray

@Composable
fun ItemDirectMessage(
    directMessage: DirectMessage
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = directMessage.user.userPhoto),
                contentDescription = "UserProfilePhoto",
                modifier = Modifier
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
                        text = directMessage.user.userName,
                        modifier = Modifier.padding(start = 8.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "@${directMessage.user.userHandle}",
                        color = TwitterGray,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                    Text(
                        text = "·",
                        color = TwitterGray,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                    Text(
                        text = calculateDate(directMessage.timeAgo),
                        color = TwitterGray,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Text(
                    text = directMessage.content,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
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
fun PreviewDirectMessage() {
    val directMessage = DirectMessage(
        user = User("Slipknot", "Slipknot", R.drawable.profile_slipknot),
        timeAgo = 48 * 60 * 60 * 1000,
        content = "Prepare for the worst.\nPrepare for the worst nightmare of your life."
    )
    ItemDirectMessage(directMessage = directMessage)
}