package com.rperez.testsneedtopass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.rperez.testsneedtopass.ui.theme.TestsNeedToPassTheme

/**
 * Main activity
 *
 * @constructor Create empty Main activity
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        /**
         * Start with compose show equation passed in
         */
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestsNeedToPassTheme {}
        }
    }
}