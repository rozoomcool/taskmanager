package com.rozoomcool.archibook.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Event
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LaptopMac
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.rounded.Event
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LaptopMac
import androidx.compose.material.icons.rounded.Newspaper
import androidx.compose.ui.graphics.vector.ImageVector
import com.rozoomcool.archibook.R

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val iconResId: ImageVector
) {
    object Home: NavigationItem(
        screen = Screen.Home,
        titleResId = R.string.screen_home,
        iconResId = Icons.Rounded.Home
    )
    object ArticlesFeed: NavigationItem(
        screen = Screen.ArticlesFeed,
        titleResId = R.string.screen_articles_feed,
        iconResId = Icons.Rounded.Newspaper
    )
    object TutorialsFeed: NavigationItem(
        screen = Screen.TutorialsFeed,
        titleResId = R.string.screen_tutorials_feed,
        iconResId = Icons.Rounded.LaptopMac
    )
    object ProjectsFeed: NavigationItem(
        screen = Screen.ProjectsFeed,
        titleResId = R.string.screen_projects_feed,
        iconResId = Icons.Rounded.Event
    )
}