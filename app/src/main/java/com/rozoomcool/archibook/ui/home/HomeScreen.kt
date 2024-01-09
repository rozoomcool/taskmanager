package com.rozoomcool.archibook.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        UserGreetingCard()
        ProjectsCarousel()
        TaskTabPanel()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProjectsCarousel() {
    val pagerState = rememberPagerState(pageCount = { 10 })
    HorizontalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(200.dp),
        contentPadding = PaddingValues(horizontal = 64.dp, vertical = 12.dp),
        modifier = Modifier
            .padding(0.dp, 16.dp)
    ) { page ->
        Card(
            modifier = Modifier
                .size(200.dp)
                .graphicsLayer {
                    val pageOffset = (
                            (pagerState.currentPage - page) + pagerState
                                .currentPageOffsetFraction
                            ).absoluteValue

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = ScaleFactor(0.5f, 0.5f),
                        stop = ScaleFactor(1f, 1f),
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).scaleX
                }
        ) {
            Text(text = "hello")
        }
    }
}

@Composable
fun UserGreetingCard() {
    Column(
        modifier = Modifier.padding(16.dp, 0.dp)
    ) {
        Text(
            "السلام عليكم",
            style = typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF1A1A1A)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text("Хороший день, чтобы ловить баги)", style = typography.bodyMedium)
    }
}

