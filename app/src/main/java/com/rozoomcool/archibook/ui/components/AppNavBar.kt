package com.rozoomcool.archibook.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rozoomcool.archibook.navigation.NavigationItem
import com.rozoomcool.archibook.navigation.NavigationState

@Composable
fun AppNavBar(navigationState: NavigationState, items: List<NavigationItem>) {
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()


    CustomNavBar {
        items.forEach { item ->

            val selected: Boolean = navBackStackEntry?.destination?.hierarchy?.any {
                it.route == item.screen.route
            } ?: false

            CustomNavBarItem(
                selected = selected,
                onClick = {
                    navigationState.navigateTo(item.screen.route)
                },
                icon = item.iconResId,
                label = { Text(stringResource(item.titleResId), fontWeight = FontWeight.ExtraBold) },
                alwaysShowLabel = false
            )
        }
    }
}

@Composable
fun CustomNavBar(navBarItems: @Composable RowScope.() -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFECECEF))
//                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                navBarItems()
                FilledIconButton(
                    shape = RoundedCornerShape(12.dp),
                    onClick = {}
                ) {
                    Icon(Icons.Rounded.Add, contentDescription = null)
                }
            }
        }
    }
}

@Composable
fun CustomNavBarItem(
    selected: Boolean,
    icon: ImageVector,
    label: @Composable () -> Unit,
    onClick: () -> Unit,
    alwaysShowLabel: Boolean
) {
    val backgroundColor = if (selected) MaterialTheme.colorScheme.background else Color.Transparent
    val contentColor = if (selected) Color(0xFF1A1A1A) else Color(0xFF2A3A4A)

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Icon(
                modifier = Modifier
                    .animateContentSize()
                    .scale(if (selected) 1.2f else 1f),
                imageVector = icon,
                contentDescription = null,
                tint = contentColor
            )
            Spacer(Modifier.width(6.dp))
            AnimatedVisibility(
                visible = selected
            ) {
                label()
            }
        }
    }
}