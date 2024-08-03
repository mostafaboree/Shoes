package com.example.shoes.presentation.Main
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp

import androidx.compose.ui.unit.sp
import com.example.shoes.R
import com.example.shoes.domin.Shoes
import com.example.shoes.presentation.Main.TrendProduct.PagerShoes
import com.example.shoes.presentation.Main.TrendProduct.Toolbar
import com.example.shoes.presentation.Main.product.ProductShoes


typealias RM= R.drawable
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ListScreen(animatedVisibilityScope:AnimatedVisibilityScope,
               sharedTransitionScope: SharedTransitionScope,
               modifier: Modifier=Modifier,

               shoeslist:List<Shoes>,
               onclik:(id:Int)->Unit,

){
var currentPade by remember { mutableStateOf(0) }

    var search  by remember { mutableStateOf("") }
      Box(modifier = Modifier
          .fillMaxSize()
          .background(Color.Black)) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)
        .background(Color.Black)) {
        Toolbar()
        Spacer(modifier = Modifier.height(20.dp))
        Search(search)
        PagerShoes(modifier = modifier,
            animatedVisibilityScope = animatedVisibilityScope,
            transitionScope = sharedTransitionScope
        ) { currentPage, pageCount ->
           currentPade=currentPage
        }

        Indecator(currentpage = currentPade, maxpage =8 , modifier =Modifier.fillMaxWidth())

                ProductShoes(onclik = onclik,
            animatedVisibilityScope = animatedVisibilityScope  ,
            transitionScope =sharedTransitionScope ,
            modifier =modifier ,
            content = { },
            shoes = shoeslist,

        )




}}}


