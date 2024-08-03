package com.example.shoes.presentation.Main.TrendProduct

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.asFloatState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.shoes.data.ShoesTrandList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@SuppressLint("RestrictedApi", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalFoundationApi::class, ExperimentalSharedTransitionApi::class)
@Composable
fun PagerShoes(
    modifier: Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope,
    transitionScope: SharedTransitionScope,
    progress:(currentPage:Int,pageCount:Int)->Unit

) {
    var scale =remember{ mutableStateOf(1f) }
    ScaleShose(scale = 1f, modifier = Modifier) {
        scale.value = it.value
    }
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 1,pageCount = {8})
    var currentPage = pagerState.currentPage
    if (currentPage<pagerState.pageCount) currentPage++
    if (currentPage==pagerState.pageCount) currentPage=0
progress(currentPage,pagerState.pageCount)
    coroutineScope.launch{
        delay(10000)

        pagerState.animateScrollToPage(currentPage,.0f, spring(dampingRatio = 1f, stiffness = 3f))
    }

    HorizontalPager(state =pagerState,  pageSize = PageSize.Fill , pageSpacing =10.dp, contentPadding = PaddingValues(end = 40.dp)
    ) { page->
        Card(modifier = Modifier.graphicsLayer {
            val pageOffset = (
                    (pagerState.currentPage - page) + pagerState
                        .currentPageOffsetFraction
                    ).absoluteValue

            alpha = lerp(
                start = 0.6f,
                stop = 1f,
                fraction = 1f - pageOffset.coerceIn(0f, 1f))
        }) {
            TrandItem(scale = scale, shoes = ShoesTrandList[page], Modifier, animatedVisibilityScope, transitionScope)
        }

    }
}
@Composable
fun ScaleShose(scale: Float, modifier: Modifier,onScale: (State<Float>) -> Unit) {
val  scaleFloat = rememberInfiniteTransition()
var scale = scaleFloat.animateFloat(
    initialValue = 1.1f,
    targetValue = .8f,
    animationSpec = infiniteRepeatable(
        animation = tween(10000),
        repeatMode = RepeatMode.Reverse
    ), label = ""
)
    onScale(scale)

}