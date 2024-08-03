@file:OptIn(ExperimentalSharedTransitionApi::class, ExperimentalSharedTransitionApi::class,
    ExperimentalSharedTransitionApi::class
)

package com.example.shoes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoes.data.ShoesProductList
import com.example.shoes.presentation.Main.ListScreen
import com.example.shoes.presentation.Main.product.ProductShoes
import com.example.shoes.presentation.detalis.DetailsScreen
import com.example.shoes.ui.theme.ShoesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoesTheme {

                   Navigation()

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

sealed class Screen(){
    object Home:Screen()
    object Details:Screen()
}
@OptIn(ExperimentalSharedTransitionApi::class)
@Preview(showBackground = true,showSystemUi = true)
@Composable
fun Navigation() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Details) }
var shoes by remember { mutableStateOf(ShoesProductList[0]) }
    SharedTransitionLayout(Modifier.fillMaxSize()) {
        AnimatedContent(targetState =currentScreen,
            transitionSpec ={
                when(targetState){
                    Screen.Home -> fadeIn(tween(500)).togetherWith(fadeOut())
                    Screen.Details -> fadeIn(tween(500)).togetherWith(fadeOut())
                }
            }
        ) {
            when(it){
                Screen.Home -> ListScreen(
                    animatedVisibilityScope =this@AnimatedContent,
                   sharedTransitionScope = this@SharedTransitionLayout,
                    modifier =Modifier ,
                    onclik =  {id->
                        currentScreen = Screen.Details
                              shoes= ShoesProductList[id-1]
                              },
                    shoeslist = ShoesProductList
                )
                Screen.Details -> DetailsScreen(
                    animatedVisibilityScope =this@AnimatedContent,
                    transitionScope = this@SharedTransitionLayout,
                   onBack = { currentScreen = Screen.Home },
                    shoes = shoes
                )
            }

        }

    }
}
