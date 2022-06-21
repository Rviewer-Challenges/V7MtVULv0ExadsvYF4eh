package com.adversegecko3.twittergeckoui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adversegecko3.twittergeckoui.R
import com.adversegecko3.twittergeckoui.repo.TwitterRepository
import com.adversegecko3.twittergeckoui.ui.items.ItemSpace
import com.adversegecko3.twittergeckoui.ui.theme.TwitterGray

@Composable
fun SpacesScreen() {
    Surface {
        AllSpacesScreen()
    }
}

@Composable
fun AllSpacesScreen() {
    Column {
        TopBarSpacesScreen()
        SpaceFeed()
    }
}

@Composable
fun TopBarSpacesScreen() {
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
            text = "Spaces",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            modifier = Modifier
                .weight(8f)
                .padding(start = 32.dp),
            letterSpacing = 0.65.sp
        )
    }
    Divider()
}

@Composable
fun SpaceFeed() {
    val twitterRepository = TwitterRepository()
    val allTrends = twitterRepository.getAllSpaces()
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        itemsIndexed(items = allTrends) { index, space ->
            if (index == 0) {
                TextSpaces(
                    arrayListOf(
                        "Spaces Spotlight",
                        "Hand picked by yours truly--listen now"
                    )
                )
            } else if (index == 2) {
                TextSpaces(
                    arrayListOf(
                        "Get these in your calendar",
                        "People you follow will be tuning in"
                    )
                )
            }
            ItemSpace(space = space)
        }
    }
}

@Composable
fun TextSpaces(alTexts: ArrayList<String>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Column {
            Text(
                text = alTexts[0],
                fontWeight = FontWeight.Black,
                fontSize = 22.sp,
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Text(
                text = alTexts[1],
                fontSize = 12.sp,
                color = TwitterGray
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SpacesScreenPreview() {
    SpacesScreen()
}