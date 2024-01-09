package com.rozoomcool.archibook.navigation

sealed class Screen(
    val route: String
) {

    object Home: Screen(ROUTE_HOME)
    object ArticlesFeed: Screen(ROUTE_ARTICLES)
    object TutorialsFeed: Screen(ROUTE_TUTORIALS)
    object ProjectsFeed: Screen(ROUTE_PROJECTS)


    private companion object {
        const val ROUTE_HOME = "home"
        const val ROUTE_ARTICLES = "articles"
        const val ROUTE_TUTORIALS = "tutorials"
        const val ROUTE_PROJECTS = "projects"
    }
}