package com.example.bai_tap_tuan3.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun RowLayout(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize().padding(top=20.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.Start,

    ){
        Header("Row layout",navController = navController)
        for(i in 1..3){
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp).clip(
                    RoundedCornerShape(10.dp)
                ).background(color = Color(red = 229, green = 229, blue = 229, alpha = 255)).padding(10.dp,15.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)

            ){
                Box(
                    modifier = Modifier.weight(1f).height(60.dp).clip(RoundedCornerShape(10.dp)).background(color = Color(
                        red = 129,
                        green = 192,
                        blue = 250,
                        alpha = 255
                    )
                    ),

                    ){}
                Box(
                    modifier = Modifier.weight(1f).height(60.dp).clip(RoundedCornerShape(10.dp)).background(color = Color(
                        red = 56,
                        green = 155,
                        blue = 253,
                        alpha = 255
                    )
                    ),

                    ){}
                Box(
                    modifier = Modifier.weight(1f).height(60.dp).clip(RoundedCornerShape(10.dp)).background(color = Color(
                        red = 129,
                        green = 192,
                        blue = 250,
                        alpha = 255
                    )
                    ),

                    ){}
            }
        }



    }
}
