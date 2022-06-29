package com.adversegecko3.twittergeckoui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adversegecko3.twittergeckoui.R
import com.adversegecko3.twittergeckoui.repo.TwitterRepository
import com.adversegecko3.twittergeckoui.ui.items.ItemCommunity
import com.adversegecko3.twittergeckoui.ui.items.ItemTweet

@Composable
fun CommunitiesScreen() {
    Surface {
        AllCommunitiesScreen()
    }
}

@Composable
fun AllCommunitiesScreen() {
    Column {
        TopBarCommunitiesScreen()
        ListCommunities()
        CommunitiesFeed()
    }
}

@Composable
fun TopBarCommunitiesScreen() {
    Row(
        modifier = Modifier
            .height(52.dp)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_adversegecko3),
            contentDescription = "User Profile Photo",
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Communities",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            modifier = Modifier
                .weight(6f)
                .padding(start = 32.dp),
            letterSpacing = 0.65.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_group_add),
            contentDescription = "Tweet Order",
            modifier = Modifier
                .weight(1f),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_nav_search_unselected),
            contentDescription = "Tweet Order",
            modifier = Modifier
                .weight(1f),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
        )
    }
    Divider()
}

@Composable
fun ListCommunities() {
    val twitterRepository = TwitterRepository()
    val allCommunities = twitterRepository.getAllCommunities()

    LazyRow {
        items(items = allCommunities) { community ->
            ItemCommunity(community = community)
        }
    }
    Divider()
}

@Composable
fun CommunitiesFeed() {
    val twitterRepository = TwitterRepository()
    val allTweets = twitterRepository.getAllCommunityTweets()

    LazyColumn {
        items(items = allTweets) { tweet ->
            ItemTweet(tweet = tweet)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CommunitiesScreenPreview() {
    CommunitiesScreen()
}