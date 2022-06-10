package com.adversegecko3.twittergeckoui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.adversegecko3.twittergeckoui.nav.MainScreen
import com.adversegecko3.twittergeckoui.ui.theme.TwitterGeckoUITheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwitterGeckoUITheme {
                MainScreen()
            }
        }
    }
}

