package com.adversegecko3.twittergeckoui.repo

import androidx.compose.ui.graphics.Color
import com.adversegecko3.twittergeckoui.R
import com.adversegecko3.twittergeckoui.model.*
import com.adversegecko3.twittergeckoui.ui.theme.*
import kotlin.random.Random

class TwitterRepository {
    fun getAllTweets(): List<Tweet> {
        return listOf(
            Tweet(
                user = User("AdverseGecko3", "adversegecko3", R.drawable.profile_adversegecko3),
                timeAgo = "1h",
                content = "Hello, world!" +
                        "\nI'm AdverseGecko3 and TwitterGeckoUI is AWESOME!" +
                        "\n\nSee ya!",
                numComments = 2,
                numRetweets = 0,
                numLikes = 6
            ),
            Tweet(
                user = User("Elon Musk", "elonmusk", R.drawable.profile_elonmusk),
                timeAgo = "8h",
                content = "Well, Twitter deal is finally Done." +
                        "\nWe will implement TwitterGeckoUI." +
                        "\nOh, and FYI, editing tweets is already being developed " +
                        String(Character.toChars(0x1F609)),
                numComments = 18945,
                numRetweets = 524978,
                numLikes = 13494688
            ),
            Tweet(
                user = User("Brais Moure", "MoureDev", R.drawable.profile_mouredev),
                timeAgo = "4h",
                content = "Buenas a todos!\nAcabo de subir un nuevo tutorial de Jetpack Compose. " +
                        "En él comento el equivalente del RecyclerView, llamado LazyColumn (o LazyRow)" +
                        "\nSi os gusta no olvideis suscribiros y dejar like!",
                numComments = 12,
                numRetweets = 10,
                numLikes = 349
            ),
            Tweet(
                user = User("IlloJuan", "LMDShow", R.drawable.profile_lmdshow),
                timeAgo = "2h",
                content = "Illo que man liao.\n\nAhora que viene el calorcito estoy más tiempo fuera de casa con los amigos " +
                        "y quizá haga menos directos\n\nNO CE ME QUEJEI " +
                        String(Character.toChars(0x1F621)) + String(Character.toChars(0x1F621)) +
                        "\n\nEso si, mañana directo pasándonos Subnautica " +
                        "y las secundarias de God of War " +
                        String(Character.toChars(0x1F608)),
                numComments = 967,
                numRetweets = 2567,
                numLikes = 59637
            ),
            Tweet(
                user = User("Formula 1", "F1", R.drawable.profile_f1),
                timeAgo = "1h",
                content = "IT'S RACE WEEK!!!\n\nFormula 1 returns to Great Britain in the 12th round of 2022!" +
                        "\n\nSome of the best moments from the previous years" +
                        String(Character.toChars(0x1F447)) + ":",
                numComments = 367,
                numRetweets = 5097,
                numLikes = 26970
            ),
            Tweet(
                user = User("NVIDIA GeForce", "NVIDIAGeForce", R.drawable.profile_nvidiageforce),
                timeAgo = "8h",
                content = "And after months of rumours... HERE THEY ARE!!!\n\nTake a look to the brand new RTX 4090Ti Super " +
                        String(Character.toChars(0x1F440)) +
                        "\nSome specs:\n\n· 1200W of Power Consumption\n· PCIe 5.0 Interface" +
                        "\n· 48GB GDDR6X\n· 16582 CUDA Cores\n· 36Gbps of memory speed" +
                        "\n· 2750 MHz Core Clock Speed (Up to 3075 MHz at OC Mode)",
                numComments = 16355,
                numRetweets = 5629,
                numLikes = 29467
            ),
            Tweet(
                user = User("Slipknot", "Slipknot", R.drawable.profile_slipknot),
                timeAgo = "48m",
                content = "6th of September\n\nSpotify, Apple Music, Amazon Music, YouTube, TIDAL and SoundCloud." +
                        "\n\nPrepare for the worst.\nPrepare for the worst nightmare of your life.",
                numComments = 64978,
                numRetweets = 89768,
                numLikes = 437987
            ),
            Tweet(
                user = User("Elon Musk", "elonmusk", R.drawable.profile_elonmusk),
                timeAgo = "8h",
                content = "Well, Twitter deal is finally Done." +
                        "\nWe will implement TwitterGeckoUI." +
                        "\nOh, and FYI, editing tweets is already being developed " +
                        String(Character.toChars(0x1F609)),
                numComments = 18945,
                numRetweets = 524978,
                numLikes = 13494688
            ),
            Tweet(
                user = User("Elon Musk", "elonmusk", R.drawable.profile_elonmusk),
                timeAgo = "8h",
                content = "Well, Twitter deal is finally Done." +
                        "\nWe will implement TwitterGeckoUI." +
                        "\nOh, and FYI, editing tweets is already being developed " +
                        String(Character.toChars(0x1F609)),
                numComments = 18945,
                numRetweets = 524978,
                numLikes = 13494688
            )
        )
    }

    fun getAllTrends(): List<Trend> {
        return listOf(
            Trend(
                type = "Trending in Music",
                title = "Slipknot",
                quantity = 0,
                image = TrendImage(
                    imageType = 0,
                    image = R.drawable.trend_slipknot
                )
            ),
            Trend(
                type = "Trending in Spain",
                title = "Jetpack Compose",
                quantity = 42_591
            ),
            Trend(
                type = "Trending in Spain",
                title = "RTX 4090",
                quantity = 57_507
            ),
            Trend(
                type = "LIVE",
                title = "Elon Musk Twitter deal",
                quantity = 817_591,
                image = TrendImage(
                    imageType = 1,
                    image = R.drawable.trend_elon_musk
                )
            ),
            Trend(
                type = "Trending in Spain",
                title = "Slipknot's album",
                quantity = 409_737
            ),
            Trend(
                type = "Trending in Spain",
                title = "Formula 1",
                quantity = 28_308
            ),
            Trend(
                type = "Ukrainian War",
                title = "Latest updates from Ukrainian War",
                quantity = 205_627,
                image = TrendImage(
                    imageType = 1,
                    image = R.drawable.trend_ukraine
                )
            ),
            Trend(
                type = "Trending in Spain",
                title = "Weekly Challenges",
                quantity = 6_627
            ),
            Trend(
                type = "Trending in Spain",
                title = "Jetpack Compose",
                quantity = 217_591
            ),
            Trend(
                type = "Trending in Spain",
                title = "Jetpack Compose",
                quantity = 217_591
            ),
            Trend(
                type = "Trending in Spain",
                title = "Jetpack Compose",
                quantity = 217_591
            )
        )
    }

    fun getAllSpaces(): List<Space> {
        return listOf(
            Space(
                title = "Slipknot",
                listeners = 64,
                host = "Slipknot",
                description = "Slipknot",
                alColors = selectSpacesColor()
            ),
            Space(
                title = "Slipknot",
                listeners = 64,
                host = "Slipknot",
                description = "Slipknot",
                alColors = selectSpacesColor()
            ),
            Space(
                title = "Slipknot",
                listeners = 64,
                host = "Slipknot",
                description = "Slipknot",
                alColors = selectSpacesColor()
            ),
            Space(
                title = "Slipknot",
                listeners = 64,
                host = "Slipknot",
                description = "Slipknot",
                alColors = selectSpacesColor()
            ),
            Space(
                title = "Slipknot",
                listeners = 64,
                host = "Slipknot",
                description = "Slipknot",
                alColors = selectSpacesColor()
            ),
            Space(
                title = "Slipknot",
                listeners = 64,
                host = "Slipknot",
                description = "Slipknot",
                alColors = selectSpacesColor()
            ),
            Space(
                title = "Slipknot",
                listeners = 64,
                host = "Slipknot",
                description = "Slipknot",
                alColors = selectSpacesColor()
            ),
            Space(
                title = "Slipknot",
                listeners = 64,
                host = "Slipknot",
                description = "Slipknot",
                alColors = selectSpacesColor()
            )
        )
    }

    private fun selectSpacesColor(): ArrayList<Color> {
        return when (Random.nextInt(0, 5)) {
            0 -> {
                arrayListOf(SpacesPurpleLight, SpacesPurpleDark)
            }
            1 -> {
                arrayListOf(SpacesRedLight, SpacesRedDark)
            }
            2 -> {
                arrayListOf(SpacesYellowLight, SpacesYellowDark)
            }
            3 -> {
                arrayListOf(SpacesGreenLight, SpacesGreenDark)
            }
            4 -> {
                arrayListOf(SpacesBlueLight, SpacesBlueDark)
            }
            else -> {
                arrayListOf(SpacesLightBlueLight, SpacesLightBlueDark)
            }
        }
    }
}