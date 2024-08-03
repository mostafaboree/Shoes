package com.example.shoes.presentation.Main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Indecator(currentpage:Int,maxpage:Int,modifier:Modifier){
    Spacer(modifier = Modifier.height(20.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically){
        Text(text = "ON  TREND",color = Color.White)
        Spacer(modifier = Modifier.width(30.dp))

       LinearProgressIndicator(progress = currentpage.toFloat()/maxpage.toFloat(),modifier = Modifier.fillMaxWidth(.6f),
            strokeCap = ProgressIndicatorDefaults.LinearStrokeCap)

       Text(buildAnnotatedString {
           withStyle(style= SpanStyle(fontSize = 16.sp,
               color = Color(0xFF96C9F4))){
               append("0$currentpage")
           }

           withStyle(style= SpanStyle(fontSize = 16.sp,
               color = Color.LightGray)){
               append("/$maxpage")
           }


    })}




}