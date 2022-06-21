package com.adversegecko3.twittergeckoui.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adversegecko3.twittergeckoui.R
import com.adversegecko3.twittergeckoui.model.Trend
import com.adversegecko3.twittergeckoui.model.TrendImage
import com.adversegecko3.twittergeckoui.reformatNumbers
import com.adversegecko3.twittergeckoui.ui.theme.TwitterGray

@Composable
fun ItemTrend(trend: Trend) {
    if (trend.image == null) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                Row {
                    Column {
                        Text(
                            text = trend.type,
                            fontSize = 12.sp,
                            color = TwitterGray,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = trend.title,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Outlined.MoreVert,
                        contentDescription = "Dots Icon"
                    )
                }
                Text(
                    text = "${trend.quantity.reformatNumbers()} Tweets",
                    fontSize = 12.sp,
                    color = TwitterGray,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    } else {
        if (trend.image.imageType == 0) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column {
                    Box(
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Image(
                            painter = painterResource(id = trend.image.image),
                            contentDescription = "Trend Image",
                            modifier = Modifier.wrapContentHeight()
                        )
                        Spacer(modifier = Modifier.wrapContentHeight())
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row {
                                Text(
                                    text = trend.type,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "·",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 2.dp)
                                )
                                Text(
                                    text = "LIVE",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Text(
                                text = trend.title,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }
                    }
                    Divider(Modifier.padding(vertical = 4.dp))
                }

            }
        } else {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Row {
                    Column(
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .weight(8f)
                    ) {
                        Text(
                            text = trend.type,
                            fontSize = 12.sp,
                            color = TwitterGray,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = trend.title,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Image(
                        painter = painterResource(id = trend.image.image),
                        contentDescription = "Trend Image",
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .weight(3f)
                            .clip(RoundedCornerShape(8.dp))
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemTrendImageBig() {
    val trend = Trend(
        type = "Trending in Spain",
        title = "Slipknot ",
        quantity = 217_591,
        image = TrendImage(
            imageType = 0,
            image = R.drawable.trend_slipknot
        )
    )
    ItemTrend(trend = trend)
}

@Preview(showBackground = true)
@Composable
fun PreviewItemTrendImageSmall() {
    val trend = Trend(
        type = "LIVE",
        title = "Elon Musk Twitter deal",
        quantity = 217_591,
        image = TrendImage(
            imageType = 1,
            image = R.drawable.trend_elon_musk
        )
    )
    ItemTrend(trend = trend)
}

@Preview(showBackground = true)
@Composable
fun PreviewItemTrend() {
    val trend = Trend(
        type = "Trending in Spain",
        title = "Jetpack Compose",
        quantity = 217_591
    )
    ItemTrend(trend = trend)
}