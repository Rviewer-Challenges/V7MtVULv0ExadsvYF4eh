package com.adversegecko3.twittergeckoui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adversegecko3.twittergeckoui.ui.items.ItemTweet
import com.adversegecko3.twittergeckoui.R
import com.adversegecko3.twittergeckoui.repo.TwitterRepository

@Composable
fun HomeScreen() {
    Surface {
        AllHomeScreen()
    }
}

@Composable
fun AllHomeScreen() {
    Column {
        TopBarHomeScreen()
        TweetFeed()
    }
}

@Composable
fun TopBarHomeScreen() {
    Row(
        modifier = Modifier
            .height(52.dp)
            .padding(vertical = 8.dp),
        verticalAlignment = CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_adversegecko3),
            contentDescription = "User Profile Photo",
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
                .clip(CircleShape)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_gecko_right),
            contentDescription = "TwitterGecko logo",
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
            modifier = Modifier.weight(7f)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_auto_awesome),
            contentDescription = "Tweet Order",
            modifier = Modifier
                .weight(1f),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
        )
    }
    Divider()
}

@Composable
fun TweetFeed() {
    val twitterRepository = TwitterRepository()
    val allTweets = twitterRepository.getAllTweets()
    
    LazyColumn {
        items(items = allTweets) { tweet ->
            ItemTweet(tweet = tweet)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}