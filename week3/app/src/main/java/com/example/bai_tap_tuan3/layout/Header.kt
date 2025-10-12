package com.example.bai_tap_tuan3.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Header(nameHeader:String,navController: NavController){
    Row(
        modifier = Modifier.fillMaxWidth().padding(20.dp,10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(imageVector = Icons.Outlined.KeyboardArrowLeft,
            contentDescription = "Quayve",
            tint = Color(0xFF03A9F4),
            modifier = Modifier.size(25.dp).weight(1f).clickable{
                navController.navigate("home")
            })

        Text((nameHeader) , fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color(0xFF03A9F4))
        Spacer(modifier = Modifier.weight(1f))
    }
}