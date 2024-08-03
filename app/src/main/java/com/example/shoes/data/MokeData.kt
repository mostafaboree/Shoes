package com.example.shoes.data

import androidx.compose.ui.graphics.Color
import com.example.shoes.R
import com.example.shoes.domin.Shoes
val size=(30..42).random()
val color= Color(red= (0..255).random().toFloat(),green = (0..255).random().toFloat(), blue = (0..255).random().toFloat()).toString()
val brand="Nike"
val name="Nike Air VaporMax 2023 "
val name1="Nike Court Borough Mid 2"
val name2="Nike Air Max 97"
val name3="Nike SB Zoom Blazer Mid Electric"
val price=(20..100).random()
val detail="Have you ever walked on Air? Step into the Air VaporMax 2023 to see how it's done. " +
        "The innovative tech is revealed through the perforated sockliner (pull it out to see more)." +
        " The stretchy Flyknit" +
        " upper is made with at least 20% recycled content by weight"
val trandshoes= listOf(R.drawable.trand1,R.drawable.trand2,R.drawable.trand3,R.drawable.trand4,
    R.drawable.trand5,R.drawable.trand6,R.drawable.sho1,R.drawable.sho9)
val  productshose= listOf(R.drawable.pro2,R.drawable.newpro1,R.drawable.prod3,R.drawable.prod4,R.drawable.newp3,
    R.drawable.s_8,R.drawable.s_3,R.drawable.s_5,R.drawable.s_6,R.drawable.pro1,)

 val ShoesTrandList= listOf(
    Shoes(1,size,color,brand,price,name,trandshoes[0], detail),
    Shoes(2,size,color,brand,price,name1,trandshoes[1], detail),
   Shoes(3,size,color,brand,price,name2,trandshoes[2], detail),
   Shoes(4,size,color,brand,price,name3,trandshoes[3], detail),
  Shoes(5,size,color,brand,price,name2,trandshoes[4], detail),
  Shoes(6,size,color,brand,price,name1,trandshoes[5], detail),
  Shoes(7,size,color,brand,price,name2,trandshoes[6], detail),
  Shoes(8,size,color,brand,price,name1,trandshoes[7], detail),
)
val ShoesProductList= listOf(
    Shoes(1,size,color,brand,price,name1, productshose[0], detail),
    Shoes(2,size,color,brand,price,name3, productshose[1], detail),
    Shoes(3,size,color,brand,price,name1, productshose[2], detail),
    Shoes(4,size,color,brand,price,name2, productshose[3], detail),
    Shoes(5,size,color,brand,price,name1,productshose[4], detail),
    Shoes(6,size,color,brand,price,name3, productshose[5], detail),
    Shoes(7,size,color,brand,price,name,productshose[6], detail),
    Shoes(8,size,color,brand,price,name1, productshose[7], detail),
    Shoes(9,size,color,brand,price,name, productshose[8], detail),


)