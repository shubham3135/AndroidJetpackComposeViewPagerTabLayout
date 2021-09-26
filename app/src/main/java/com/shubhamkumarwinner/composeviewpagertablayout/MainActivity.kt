package com.shubhamkumarwinner.composeviewpagertablayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.google.android.material.animation.*
import com.google.android.material.math.MathUtils.lerp
import com.shubhamkumarwinner.composeviewpagertablayout.ui.theme.ComposeViewPagerTabLayoutTheme
import kotlin.math.absoluteValue

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeViewPagerTabLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HorizontalViewPager()
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun HorizontalViewPager() {
    val listOfImage = listOf(
        R.drawable.pic0,
        R.drawable.pic1,
        R.drawable.pic2,
        R.drawable.pic3,
        R.drawable.pic4,
        R.drawable.pic5,
        R.drawable.pic6,
        R.drawable.pic7,
        R.drawable.pic8,
        R.drawable.pic9,
        R.drawable.pic10,
        R.drawable.pic11
    )
    val pagerState = rememberPagerState(pageCount = listOfImage.size, initialOffscreenLimit = 2)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            HorizontalPager(state = pagerState) { page ->
                Card(
                    Modifier
                        .graphicsLayer {
                            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                            lerp(
                                0.65f,
                                1f,
                                1f - pageOffset.coerceIn(0f, 1f)
                            ).also { scale ->
                                scaleX = scale
                                scaleY = scale
                            }

                            alpha = lerp(
                                0.5f,
                                1f,
                                1f - pageOffset.coerceIn(0f, 1f)
                            )
                        }
                ) {
                    Image(
                        painter = painterResource(id = listOfImage[page]),
                        contentDescription = "image$page",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
            )
        }
    }

}

