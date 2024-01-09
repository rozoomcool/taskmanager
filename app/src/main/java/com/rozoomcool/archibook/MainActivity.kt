package com.rozoomcool.archibook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.rozoomcool.archibook.ui.ArchibookMainScreen
import com.rozoomcool.archibook.ui.components.AppBar
import com.rozoomcool.archibook.ui.theme.ArchibookTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            window.statusBarColor = MaterialTheme.colorScheme.background.toArgb()
            window.navigationBarColor = MaterialTheme.colorScheme.background.toArgb()

            ArchibookTheme {
                ArchibookMainScreen()
            }
        }
    }
}