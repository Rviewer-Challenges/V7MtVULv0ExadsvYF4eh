package com.adversegecko3.twittergeckoui.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adversegecko3.twittergeckoui.R
import com.adversegecko3.twittergeckoui.model.Community

@Composable
fun ItemCommunity(community: Community) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(150.dp)
            .padding(vertical = 16.dp, horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = community.image),
                    contentDescription = "Community Image",
                    contentScale = ContentScale.Crop
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(community.color)
            ) {
                Text(
                    text = community.name,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemCommunity() {
    val community = Community(
        name = "Homies",
        image = R.drawable.community_homies,
        color = Color.Red
    )
    ItemCommunity(community)
}