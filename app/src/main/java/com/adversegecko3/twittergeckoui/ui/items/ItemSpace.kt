package com.adversegecko3.twittergeckoui.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adversegecko3.twittergeckoui.R
import com.adversegecko3.twittergeckoui.model.Space
import com.adversegecko3.twittergeckoui.reformatNumbers
import com.adversegecko3.twittergeckoui.ui.theme.*

@Composable
fun ItemSpace(space: Space) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .background(space.alColors[0])
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                ) {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_voice_wave),
                            contentDescription = "Voice Icon",
                            tint = Color.White
                        )
                        Text(
                            text = "LIVE",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 16.dp)
                                .align(CenterVertically)
                        )
                        Icon(
                            imageVector = Icons.Outlined.MoreVert,
                            contentDescription = "Voice Icon",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = space.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                    Row(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile_elonmusk),
                            contentDescription = "User Profile Photo",
                            modifier = Modifier
                                .weight(1f)
                                .clip(CircleShape)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.profile_adversegecko3),
                            contentDescription = "User Profile Photo",
                            modifier = Modifier
                                .weight(1f)
                                .offset(x = (-8).dp)
                                .clip(CircleShape)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.profile_elonmusk),
                            contentDescription = "User Profile Photo",
                            modifier = Modifier
                                .weight(1f)
                                .offset(x = (-16).dp)
                                .clip(CircleShape)
                        )
                        Text(
                            text = "${space.listeners.reformatNumbers()} listening",
                            color = Color.White,
                            modifier = Modifier
                                .weight(10f)
                                .offset(x = (-4).dp)
                                .align(CenterVertically)
                        )
                    }

                }
            }
            Box(
                modifier = Modifier
                    .background(space.alColors[1])
            ) {
                Column(
                    modifier = Modifier.padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile_elonmusk),
                            contentDescription = "User Profile Photo",
                            modifier = Modifier
                                .weight(1f)
                                .clip(CircleShape)
                        )
                        Row(
                            Modifier
                                .weight(15f)
                                .align(CenterVertically)
                        ) {
                            Text(
                                text = space.host,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier
                                    .padding(horizontal = 8.dp)
                            )
                            Text(
                                text = "Host",
                                color = Color.White,
                                modifier = Modifier
                                    .background(
                                        color = Color(0x44888888),
                                        shape = RoundedCornerShape(3.dp)
                                    )
                                    .padding(horizontal = 4.dp)
                            )
                        }
                    }
                    if (space.description.isNotEmpty()) {
                        Text(
                            text = space.description,
                            color = Color.White,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemSpace() {
    val space = Space(
        title = "Slipknot's new album will be released on 29th October!!!!",
        listeners = 34_219,
        host = "AdverseGecko3",
        description = "YES YES YES! Finally a new album is coming out after 3 years!!! " +
                "As far as we know it has minimum 5 tracks, being one of them a collaboration with KoRn!!" +
                "Join to spare the hype!!!!",
        alColors = arrayListOf(SpacesBlueLight, SpacesBlueDark)
    )
    ItemSpace(space)
}