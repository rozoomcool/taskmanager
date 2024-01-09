package com.rozoomcool.archibook.ui.home

sealed class TaskTabPanelItem(
    val tabTitle: String
) {
    data object DoTabItem: TaskTabPanelItem("Сделать")
    data object InWorkTabItem: TaskTabPanelItem("В работе")
    data object CheckTabItem: TaskTabPanelItem("Проверить")
    data object CompletedTabItem: TaskTabPanelItem("Завершено")
}