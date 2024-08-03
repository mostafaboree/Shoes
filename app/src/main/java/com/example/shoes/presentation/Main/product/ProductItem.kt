package com.example.shoes.presentation.Main.product

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoes.domin.Shoes

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ProductItem(
    onClick: (id: Int) -> Unit,
    modifier: Modifier ,
    shoes: Shoes,
    animatedVisibilityScope: AnimatedVisibilityScope,
    transitionScope: SharedTransitionScope,
    //selectShoes:(id:Int)->Unit


) {
    with(transitionScope) {

            Box(
                modifier = Modifier
                    .background(Color.Black).size(150.dp, 200.dp).clickable {

                    }) {
                Box(
                    modifier = Modifier.fillMaxSize().align(Alignment.BottomCenter)

                        .padding(top = 40.dp, start = 10.dp, end = 10.dp, bottom = 40.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color(0xFF9290C3),
                                    Color(0xFF535C91),
                                    Color(0xFF1B1A55)
                                )
                            ), shape = RoundedCornerShape(topStart = 20.dp, topEnd = 90.dp, bottomStart = 20.dp, bottomEnd = 20.dp)
                        )

                ) {
                    Text(
                        text = "$ ${shoes.price}",
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.sharedElement(
                            rememberSharedContentState(key = "price${shoes.id}"),
                            animatedVisibilityScope = animatedVisibilityScope
                        )
                            .align(Alignment.BottomStart)
                            .padding(10.dp)
                    )

                    Icon(
                        imageVector = Icons.Sharp.FavoriteBorder,
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(40.dp)
                            .padding(10.dp),
                        tint = Color.White
                    )

                }
                Image(
                    painter = painterResource(shoes.Image),
                    contentDescription = null,
                    modifier = Modifier
                        .sharedElement(
                            rememberSharedContentState(key = "image${shoes.id}"),
                            animatedVisibilityScope = animatedVisibilityScope
                        ).clickable {
                            onClick(shoes.id)}
                        .size(150.dp, 150.dp)

                        .rotate(-20f)
                        .padding(start = 10.dp,bottom = 20.dp)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Inside,
                    alignment = Alignment.TopEnd
                )
                Text(
                    text = shoes.name,
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .sharedElement(
                            rememberSharedContentState(key = "name${shoes.id}"),
                            animatedVisibilityScope = animatedVisibilityScope
                        )
                        .align(Alignment.BottomCenter)
                        .padding(end = 10.dp),
                    textAlign = TextAlign.Start
                )

            }
        }

}


