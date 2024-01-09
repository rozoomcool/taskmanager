package com.rozoomcool.archibook.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun TaskTabPanel() {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val tabPanelItem = listOf(
        TaskTabPanelItem.DoTabItem,
        TaskTabPanelItem.InWorkTabItem,
        TaskTabPanelItem.CheckTabItem,
        TaskTabPanelItem.CompletedTabItem
    )


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.Transparent,
        ) {
            tabPanelItem.forEachIndexed { it, item ->
                val selected: Boolean = selectedTabIndex == it
                Tab(
                    selected = selected,
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    onClick = { selectedTabIndex = it }
                ) {
                    Box(
                        modifier =
                        Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp))
                            .background(if (selected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant)
                            .padding(4.dp, 8.dp),
                    ) {
                        Text(item.tabTitle, overflow = TextOverflow.Ellipsis, maxLines = 1)
                    }
                }
            }
        }
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 8.dp,
                bottomEnd = 8.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .height(200.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant),
            ) {
                when (selectedTabIndex) {
                    0 -> Text("DO")
                    1 -> Text("WORK")
                    2 -> Text("Check")
                    3 -> Text("Complete")
                }
            }

        }
    }
}

@Composable
fun TaskListCard() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(1f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Задачи", style = MaterialTheme.typography.titleMedium)
                Text("15")
            }
        }
    }
}