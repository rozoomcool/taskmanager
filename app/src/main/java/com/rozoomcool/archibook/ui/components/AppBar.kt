package com.rozoomcool.archibook.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rozoomcool.archibook.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String = stringResource(id = R.string.app_name)) {
    TopAppBar(title = {
        Text(title)
    },
        actions = {
            IconButton(
                onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier.size(36.dp),
                )
            }
        })
}