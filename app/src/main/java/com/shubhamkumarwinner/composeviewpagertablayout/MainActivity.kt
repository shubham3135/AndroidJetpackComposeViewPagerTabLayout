package com.shubhamkumarwinner.composeviewpagertablayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.shubhamkumarwinner.composeviewpagertablayout.ui.theme.ComposeViewPagerTabLayoutTheme

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeViewPagerTabLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    VerticalViewPager()
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun VerticalViewPager() {
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

    VerticalPager(state = pagerState) { page ->
        // Our page content
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = listOfImage[page]),
                contentDescription = "image$page",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }

    }
}

