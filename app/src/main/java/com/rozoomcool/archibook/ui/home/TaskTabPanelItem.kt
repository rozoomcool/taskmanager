package com.rozoomcool.archibook.ui.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.LibraryAddCheck
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Work
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TaskTabPanelItem(
    val tabTitle: String,
    val imageVector: ImageVector
) {
    data object DoTabItem: TaskTabPanelItem("Сделать", Icons.Filled.CalendarMonth)
    data object InWorkTabItem: TaskTabPanelItem("В работе", Icons.Filled.Work)
    data object CheckTabItem: TaskTabPanelItem("Проверить", Icons.Filled.RemoveRedEye)
    data object CompletedTabItem: TaskTabPanelItem("Завершено", Icons.Filled.LibraryAddCheck)
}