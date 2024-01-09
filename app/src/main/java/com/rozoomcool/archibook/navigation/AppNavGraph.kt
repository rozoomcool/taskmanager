package com.rozoomcool.archibook.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    homeScreenContent: @Composable () -> Unit,
    articlesFeedScreenContent: @Composable () -> Unit,
    tutorialsFeedScreenContent: @Composable () -> Unit,
    projectsFeedScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            homeScreenContent()
        }
        composable(Screen.ArticlesFeed.route) {
            articlesFeedScreenContent()
        }
        composable(Screen.TutorialsFeed.route) {
            tutorialsFeedScreenContent()
        }
        composable(Screen.ProjectsFeed.route) {
            projectsFeedScreenContent()
        }
    }
}