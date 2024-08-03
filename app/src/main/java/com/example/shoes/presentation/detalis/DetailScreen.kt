package com.example.shoes.presentation.detalis

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoes.R
import com.example.shoes.data.color
import com.example.shoes.domin.Shoes
import com.example.shoes.presentation.Main.RM

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
 fun DetailsScreen(
     animatedVisibilityScope: AnimatedVisibilityScope,
     transitionScope: SharedTransitionScope,
     onBack: () -> Unit,
     shoes: Shoes
 ){
    val  scaleFloat = rememberInfiniteTransition()
    val rotate= rememberInfiniteTransition()
    val rotateFloat = rotate.animateFloat(initialValue = 0f, targetValue = 360f, animationSpec =
    infiniteRepeatable(
        animation = tween(100000),
        repeatMode = RepeatMode.Reverse
    ), label = "rotate")

    var scale = scaleFloat.animateFloat(
        initialValue = 1.2f,
        targetValue = .8f,
        animationSpec = infiniteRepeatable(
            animation = tween(100000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
with(transitionScope){
    Column(modifier = Modifier
        .sharedBounds(
            rememberSharedContentState(key = "box${shoes.id}"),
            animatedVisibilityScope = animatedVisibilityScope,

            )
        .fillMaxSize()
        .background(Color.Black)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Toolbar(onBack)
            ProductIamge(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.45f),
                shoes = shoes,
                rotateFloat = rotateFloat.value,
                scale = scale.value,
                animatedVisibilityScope = animatedVisibilityScope,
                transitionScope =transitionScope
            )
            Spacer(modifier = Modifier.height(20.dp))
            RetaingBar()
            Text(text = " $ ${shoes.price}",fontSize = 30.sp,color = Color.hsv(147f, 0.5f, 0.5f), fontWeight = FontWeight.Bold,
               fontFamily = FontFamily.Cursive,modifier = Modifier.sharedElement(
                   rememberSharedContentState(key = "price${shoes.id}"),
                   animatedVisibilityScope = animatedVisibilityScope
               )

               )
             Text(text = shoes.description,fontSize = 14.sp,color = Color.LightGray, fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                maxLines = 5,overflow = androidx.compose.ui.text.style.TextOverflow.Visible,modifier = Modifier
                     .padding(10.dp)
                     .sharedElement(
                         rememberSharedContentState(key = "name${shoes.id}"),
                         animatedVisibilityScope = animatedVisibilityScope
                     ))

ItemColor()
            Action()
            Text(text = "$120",fontSize = 30.sp,color = Color.hsv(147f, 0.5f, 0.5f), fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive)

        }

        }

    }}


@Composable
private fun Toolbar(onBack: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription ="",modifier = Modifier
                .size(30.dp)
                .clickable {
                    onBack()
                } ,tint = Color.White)
        Image(
            painter = painterResource(id = R.drawable.nike),
            contentDescription = "list_icon",
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.FillBounds
        )
        Image(
            painter = painterResource(id = R.drawable.cart),
            contentDescription = "list_icon", modifier = Modifier.size(40.dp)
        )
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
 private  fun ProductIamge(
     modifier: Modifier = Modifier,
     shoes: Shoes,
     rotateFloat: Float,
     scale: Float,
     animatedVisibilityScope: AnimatedVisibilityScope
     ,transitionScope: SharedTransitionScope
 ){
     with(transitionScope){
         Column(modifier = Modifier.fillMaxWidth()) {
             Box(modifier = Modifier
                 .align(Alignment.CenterHorizontally)
                 .fillMaxHeight(.45f)
                 .fillMaxWidth() ){
                 Image(painter = painterResource(id = R.drawable.bac), contentDescription = null,
                     modifier = Modifier

                         .padding(top = 20.dp, start = 5.dp, end = 5.dp)
                         .fillMaxSize()
                         .align(Alignment.Center)
                         .shadow(10.dp, RoundedCornerShape(30.dp), true, Color.Black, Color.Cyan)
                         .clip(
                             RoundedCornerShape(30.dp)
                         ),contentScale = ContentScale.FillBounds)
                 Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "",modifier = Modifier
                     .size(70.dp)
                     .align(Alignment.TopEnd)
                     .padding(top = 30.dp, end = 20.dp),tint = Color.LightGray
                 )

                 Image(painter = painterResource(shoes.Image), contentDescription = null,
                     modifier = Modifier
                         .sharedElement(
                             rememberSharedContentState(key = "image${shoes.id}"),
                             animatedVisibilityScope = animatedVisibilityScope
                         )
                         .fillMaxSize()
                         .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                         .align(Alignment.TopEnd)
                         .rotate(rotateFloat)
                         .scale(scale)
                     ,alignment = Alignment.TopEnd,contentScale = ContentScale.Fit)





             }
         }
     }}

@Composable
fun RetaingBar(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
        Text(text = "Nike Air Max 97",fontSize = 20.sp,color = Color.White, fontWeight = FontWeight.ExtraBold)
        Row(){
            for (i in 1..5){
                RatingStar(select = i<=4)
            }
        }}


    }
@Composable
fun ItemColor(){
    val avalibleColor= listOf(
        Color(0xFFE88D67),
        Color(0xFF1679AB),
        Color(0xFF1A2130),
        Color(0xFF6DC5D1),
        Color(0xFFD20062),
    )
    Column(Modifier.fillMaxWidth(),verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.Start) {
Text(text = "COLORS",fontSize = 20.sp,color = Color.LightGray, fontWeight = FontWeight.ExtraBold,
    fontFamily = FontFamily.Serif)
        Spacer(modifier = Modifier.height(10.dp))
       LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
           items(avalibleColor){color->
                Box(modifier = Modifier
                    .size(30.dp).background(color = color, CircleShape))

        }}
    }}
@Composable
fun Action(){
    Row(modifier = Modifier
        .fillMaxSize()
        , horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
        Button(onClick = { /*TODO*/ },modifier = Modifier
            .height(60.dp)
            .weight(1f)
            .padding(end = 10.dp),shape =
        RoundedCornerShape(10.dp),colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null,tint = Color.DarkGray)
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "ADD TO CART",color = Color.DarkGray)
            
        }
        Button(onClick = { /*TODO*/ },modifier = Modifier
            .height(60.dp)
            .weight(1f),shape =RoundedCornerShape(10.dp)) {
            Image(painter = painterResource(id = RM.hand), contentDescription = null,modifier = Modifier.size(50.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "BUY NOW",color = Color.White)
    }
}}

@Composable
fun RatingStar(select: Boolean){
    val selectColor = Color(0xFF8576FF)
    Icon(imageVector = Icons.Default.Star, contentDescription = null,tint =  if (select) selectColor else Color.LightGray)

}