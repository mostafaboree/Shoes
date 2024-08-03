package com.example.shoes.presentation.Main.TrendProduct

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoes.R
import com.example.shoes.domin.Shoes

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun TrandItem(scale: State<Float>,
                           shoes: Shoes, modifier: Modifier,
                           animatedVisibilityScope: AnimatedVisibilityScope,
                           transitionScope: SharedTransitionScope
) {
    var love by remember { mutableStateOf(false) }
    with(transitionScope) {
        Box(
            Modifier
                .fillMaxHeight(.5f)
                .background(Color.Black))
        {
            Image(
                painter = painterResource(id = R.drawable.bac), contentDescription = null,
                modifier = Modifier
                    .padding(top = 40.dp,end = 10.dp)
                    .sharedElement(
                        rememberSharedContentState(key = "bag${shoes.id}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                    .fillMaxSize().fillMaxHeight().align(Alignment.Center)
                    .clip(
                        RoundedCornerShape(30.dp)
                    ), contentScale = ContentScale.FillBounds
            )
            Icon(
                imageVector = if (love) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "",
                modifier = Modifier
                    .clickable {
                        love = !love
                    }
                    .size(70.dp)
                    .align(Alignment.TopEnd)
                    .padding(top = 40.dp, end = 20.dp),
                tint =if (love) Color.Red else Color.LightGray
            )

            Image(
                painter = painterResource(shoes.Image), contentDescription = null,
                modifier = Modifier
                    .sharedElement(
                        rememberSharedContentState(key = "imaget${shoes.id}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    ).rotate(-10f)
                    .fillMaxSize()
                    .padding(bottom = 70.dp, start = 30.dp,end = 20.dp)
                    .scale(scale.value)
                    .align(Alignment.TopEnd), contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(start = 10.dp, bottom = 10.dp)
            ) {
                trand_text("${shoes.name}", Modifier.sharedElement(
                    rememberSharedContentState(key = "namet${shoes.id}"),
                    animatedVisibilityScope = animatedVisibilityScope
                ))
                trand_text("${shoes.brand}", Modifier.sharedElement(
                    rememberSharedContentState(key = "brandt${shoes.id}"),
                    animatedVisibilityScope = animatedVisibilityScope
                ))
                trand_text(" $ ${shoes.price}",modifier.sharedElement(
                    rememberSharedContentState(key = "pricet${shoes.id}"),
                    animatedVisibilityScope = animatedVisibilityScope
                ))

            }


        }
    }
}

@Composable
private fun trand_text(text: String, modifier: Modifier) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 20.sp,
        color = Color.hsv(180f, .1f, 0.8f),
        fontWeight = FontWeight.Bold
    )
}
