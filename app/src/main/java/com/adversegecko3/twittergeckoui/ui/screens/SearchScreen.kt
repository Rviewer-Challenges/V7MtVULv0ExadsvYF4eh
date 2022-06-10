package com.adversegecko3.twittergeckoui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adversegecko3.twittergeckoui.R
import com.adversegecko3.twittergeckoui.repo.TwitterRepository
import com.adversegecko3.twittergeckoui.ui.items.ItemTrend
import com.adversegecko3.twittergeckoui.ui.theme.*

@Composable
fun SearchScreen() {
    Surface {
        AllSearchScreen()
    }
}

@Composable
fun AllSearchScreen() {
    Column {
        TopBarSearchScreen()
        TrendFeed()
    }
}

@Composable
fun TopBarSearchScreen() {
    val textState = remember { mutableStateOf("") }
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
        BasicTextField(
            value = textState.value,
            onValueChange = {
                textState.value = it
            },
            modifier = Modifier
                .weight(7f)
                .padding(horizontal = 16.dp)
                .fillMaxHeight(),
            cursorBrush = SolidColor(MaterialTheme.colors.primary),
            decorationBox = { innerTextField ->
                val searchColor = if (isSystemInDarkTheme()) {
                    SearchBackgroundDark
                } else {
                    SearchBackgroundLight
                }
                Box(
                    Modifier
                        .background(searchColor, RoundedCornerShape(35.dp))
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (textState.value.isEmpty()) {
                        Text(
                            text = "Search Twitter",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    }
                    innerTextField()
                }
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.primary
            ),
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
        )
        Image(
            imageVector = Icons.Outlined.Settings,
            contentDescription = "Tweet Order",
            modifier = Modifier
                .weight(1f),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
        )
    }
    Divider()
}

@Composable
fun TrendFeed() {
    val twitterRepository = TwitterRepository()
    val allTrends = twitterRepository.getAllTrends()

    LazyColumn {
        items(items = allTrends) { trend ->
            ItemTrend(trend = trend)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}