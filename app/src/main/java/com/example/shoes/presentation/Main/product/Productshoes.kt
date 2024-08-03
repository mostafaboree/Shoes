package com.example.shoes.presentation.Main.product

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.BottomAppBarDefaults.ContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.shoes.domin.Shoes
//import com.example.shoes.presentation.components.ProductItem
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ProductShoes(
    onclik: (id: Int) -> Unit,
    animatedVisibilityScope: AnimatedVisibilityScope,
    transitionScope: SharedTransitionScope,
    modifier: Modifier,
    content: @Composable () -> Unit,
    shoes:List<Shoes>,


){
    val lazyRowstate = rememberLazyListState()
    LazyRow(modifier = modifier, verticalAlignment = Alignment.CenterVertically, contentPadding = ContentPadding) {
        items(shoes,key = {shoes -> shoes.id}) { shoes ->

          ProductItem(
              onClick = onclik,
              modifier = modifier,
              shoes = shoes,
              animatedVisibilityScope = animatedVisibilityScope,
              transitionScope = transitionScope,

          )
        }

    }


}