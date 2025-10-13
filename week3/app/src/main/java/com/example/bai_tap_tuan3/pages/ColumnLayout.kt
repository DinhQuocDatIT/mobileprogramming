package com.example.bai_tap_tuan3.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bai_tap_tuan3.layout.Header

@Composable
fun ColumnLayout(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize().padding(top=20.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.Start,

        ){
        Header("Column layout",navController = navController)
        Column (modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp)).background(color = Color(red = 229, green = 229, blue = 229, alpha = 255)).padding(12.dp,15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)){
            Box(modifier = Modifier.fillMaxWidth().height(80.dp).clip(RoundedCornerShape(15.dp)).background(color = Color(
                red = 176,
                green = 246,
                blue = 182,
                alpha = 255
            )
            )){

            }
            Box(modifier = Modifier.fillMaxWidth().height(80.dp).clip(RoundedCornerShape(15.dp)).background(color = Color(
                red = 105,
                green = 211,
                blue = 113,
                alpha = 255
            )
            )){

            }
            Box(modifier = Modifier.fillMaxWidth().height(80.dp).clip(RoundedCornerShape(15.dp)).background(color = Color(
                red = 176,
                green = 246,
                blue = 182,
                alpha = 255
            )
            )){

            }
        }
    }
}
