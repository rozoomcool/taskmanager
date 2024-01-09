package com.rozoomcool.archibook.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rozoomcool.archibook.navigation.AppNavGraph
import com.rozoomcool.archibook.navigation.NavigationItem
import com.rozoomcool.archibook.navigation.Screen
import com.rozoomcool.archibook.navigation.rememberNavigationState
import com.rozoomcool.archibook.ui.components.AppBar
import com.rozoomcool.archibook.ui.components.AppNavBar
import com.rozoomcool.archibook.ui.home.HomeScreen

@Composable
fun ArchibookMainScreen() {
    val navigationState = rememberNavigationState()

    Scaffold(
        topBar = {
            AppBar()
        },
        bottomBar = {
            val items = listOf(
                NavigationItem.Home,
                NavigationItem.TutorialsFeed,
                NavigationItem.ProjectsFeed
            )
            
            AppNavBar(navigationState = navigationState, items = items)
            
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colorScheme.background
        ) {

            AppNavGraph(
                navHostController = navigationState.navHostController,
                homeScreenContent = { HomeScreen() },
                articlesFeedScreenContent = {},
                tutorialsFeedScreenContent = {},
                projectsFeedScreenContent = {})

        }
    }
}