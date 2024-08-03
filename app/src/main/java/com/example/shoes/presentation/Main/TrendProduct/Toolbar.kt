package com.example.shoes.presentation.Main.TrendProduct

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.shoes.R

@Composable
 fun Toolbar() {
    Row(
        Modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.list),
            contentDescription = "list_icon", modifier = Modifier.size(40.dp)
        )
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