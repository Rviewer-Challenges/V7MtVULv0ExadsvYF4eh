package com.adversegecko3.twittergeckoui.repo

import androidx.compose.ui.graphics.Color
import com.adversegecko3.twittergeckoui.R
import com.adversegecko3.twittergeckoui.model.*
import com.adversegecko3.twittergeckoui.ui.theme.*

class TwitterRepository {

    private val minutes = 60 * 1000L
    private val hours = 60 * minutes
    private val days = 24 * hours

    fun getAllTweets(): List<Tweet> {
        return listOf(
            Tweet(
                user = User("AdverseGecko3", "adversegecko3", R.drawable.profile_adversegecko3),
                timeAgo = 6 * hours,
                content = "Hello, world!" +
                        "\nI'm AdverseGecko3 and TwitterGeckoUI is AWESOME!" +
                        "\n\nSee ya!",
                numComments = 2,
                numRetweets = 0,
                numLikes = 6
            ),
            Tweet(
                user = User("Elon Musk", "elonmusk", R.drawable.profile_elonmusk),
                timeAgo = 15 * hours,
                content = "Well, Twitter deal is finally Done." +
                        "\nWe will implement TwitterGeckoUI." +
                        "\nOh, and FYI, editing tweets is already being developed " +
                        String(Character.toChars(0x1F609)),
                numComments = 18_945,
                numRetweets = 524_978,
                numLikes = 13_494_688
            ),
            Tweet(
                user = User("Brais Moure", "MoureDev", R.drawable.profile_mouredev),
                timeAgo = (1 * hours) + (17 * minutes),
                content = "Buenas a todos!\nAcabo de subir un nuevo tutorial de Jetpack Compose. " +
                        "En él comento el equivalente del RecyclerView, llamado LazyColumn (o LazyRow)" +
                        "\nSi os gusta no olvideis suscribiros y dejar like!",
                numComments = 12,
                numRetweets = 10,
                numLikes = 349
            ),
            Tweet(
                user = User("IlloJuan", "LMDShow", R.drawable.profile_lmdshow),
                timeAgo = 2 * hours,
                content = "Illo que man liao.\n\nAhora que viene el calorcito estoy más tiempo fuera de casa con los amigos " +
                        "y quizá haga menos directos\n\nNO CE ME QUEJEI " +
                        String(Character.toChars(0x1F621)) + String(Character.toChars(0x1F621)) +
                        "\n\nEso si, mañana directo pasándonos Subnautica " +
                        "y las secundarias de God of War " +
                        String(Character.toChars(0x1F608)),
                numComments = 967,
                numRetweets = 2_567,
                numLikes = 59_637
            ),
            Tweet(
                user = User("Formula 1", "F1", R.drawable.profile_f1),
                timeAgo = 4 * hours,
                content = "IT'S RACE WEEK!!!\n\nFormula 1 returns to Great Britain in the 12th round of 2022!" +
                        "\n\nSome of the best moments from the previous years" +
                        String(Character.toChars(0x1F447)) + ":",
                numComments = 367,
                numRetweets = 5_097,
                numLikes = 26_970
            ),
            Tweet(
                user = User("NVIDIA GeForce", "NVIDIAGeForce", R.drawable.profile_nvidiageforce),
                timeAgo = days + (3 * hours) + (29 * minutes),
                content = "And after months of rumours... HERE THEY ARE!!!\n\nTake a look to the brand new RTX 4090Ti Super " +
                        String(Character.toChars(0x1F440)) +
                        "\nSome specs:\n\n· 1200W of Power Consumption\n· PCIe 5.0 Interface" +
                        "\n· 48GB GDDR6X\n· 16582 CUDA Cores\n· 36Gbps of memory speed" +
                        "\n· 2750 MHz Core Clock Speed (Up to 3075 MHz at OC Mode)",
                numComments = 16_355,
                numRetweets = 5_629,
                numLikes = 29_467
            ),
            Tweet(
                user = User("Slipknot", "Slipknot", R.drawable.profile_slipknot),
                timeAgo = 48 * minutes,
                content = "6th of September\n\nSpotify, Apple Music, Amazon Music, YouTube, TIDAL and SoundCloud." +
                        "\n\nPrepare for the worst.\nPrepare for the worst nightmare of your life.",
                numComments = 64_978,
                numRetweets = 89_768,
                numLikes = 437_987
            ),
            Tweet(
                user = User("PlayStation", "PlayStation", R.drawable.profile_elonmusk),
                timeAgo = days + (53 * minutes),
                content = "Yes, another fan favorite exclusive PS game is coming to PC!" +
                        "\nSpider-Man remastered will arrive the 12th of August.",
                numComments = 930,
                numRetweets = 3_912,
                numLikes = 25_091
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
                type = "Trending in Gaming",
                title = "RTX 4090",
                quantity = 57_507
            ),
            Trend(
                type = "LIVE",
                title = "Elon Musk Twitter deal",
                quantity = 0,
                image = TrendImage(
                    imageType = 1,
                    image = R.drawable.trend_elon_musk
                )
            ),
            Trend(
                type = "Trending in Music",
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
                quantity = 0,
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
                type = "Trending in Music",
                title = "#ResurrectionFest",
                quantity = 21_649
            ),
            Trend(
                type = "Trending in Technology",
                title = "Kotlin",
                quantity = 217_591
            ),
            Trend(
                type = "Trending in Gaming",
                title = "Spider-Man is coming to PC",
                quantity = 0,
                image = TrendImage(
                    imageType = 1,
                    image = R.drawable.trend_spiderman
                )
            ),
            Trend(
                type = "Trending in Crypto",
                title = "#Cryptocrash",
                quantity = 537_109
            )
        )
    }

    fun getAllSpaces(): List<Space> {
        return listOf(
            Space(
                title = "Prepare for the worst nightmare of your life",
                listeners = 13_167,
                host = "Slipknot",
                description = "Be prepared, that's all.",
                alColors = selectSpacesColor()
            ),
            Space(
                title = "#LatinosUnidos #Ramona #Viral #HablemosconRamonaoficial #Ruedadeprensa",
                listeners = 35_129,
                host = "Ramona",
                description = "",
                alColors = selectSpacesColor()
            ),
            Space(
                title = "Barça - Madrid",
                listeners = 367,
                host = "433",
                description = "Furbo",
                alColors = selectSpacesColor()
            ),
            Space(
                title = "NFT's are the future\n\nPrices are 0, but anyways!!! ",
                listeners = 1,
                host = "Bored Ape Yacht Club",
                description = "please help. i've sold everything for a monke " +
                        "and now i only have a bunch of pixels. please help me",
                alColors = selectSpacesColor()
            ),
            Space(
                title = "Xbox Showcase event",
                listeners = 1_487,
                host = "Xbox",
                description = "And remember, all games will be available Day 1 on GamePass",
                alColors = selectSpacesColor()
            ),
            Space(
                title = "Pigeon overpopulation. WE HAVE TO DO SOMETHING!",
                listeners = 291,
                host = "SpicyCranker42",
                description = "The number keeps getting bigger and bigger and we should take measures." +
                        "Remember in GTA IV you had to kill 200 pigeons... Well, it should be something more than that.",
                alColors = selectSpacesColor()
            ),
            Space(
                title = "Microsoft launches glasses to live on a Metaverse #Future",
                listeners = 634,
                host = "TechMex",
                description = "",
                alColors = selectSpacesColor()
            )
        )
    }

    private fun selectSpacesColor(): ArrayList<Color> {
        return when ((0..5).random()) {
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