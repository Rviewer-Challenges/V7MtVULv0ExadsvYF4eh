package com.adversegecko3.twittergeckoui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.SideEffect
import com.adversegecko3.twittergeckoui.nav.MainScreen
import com.adversegecko3.twittergeckoui.ui.theme.TwitterGeckoUITheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwitterGeckoUITheme {
                val systemUiController = rememberSystemUiController()
                val color = MaterialTheme.colors.surface
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = color
                    )
                }
                MainScreen()
            }
        }
    }
}