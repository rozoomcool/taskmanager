package com.rozoomcool.archibook.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Column {
        UserGreetingCard()

    }
}

@Composable
fun UserGreetingCard() {
    Column(
        modifier = Modifier.padding(16.dp, 0.dp)
    ) {
        Text(
            "Ассалам Алейкум",
            style = typography.headlineMedium,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF1A1A1A)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text("Хороший день, чтобы ловить баги)", style = typography.bodyMedium)
    }
}

