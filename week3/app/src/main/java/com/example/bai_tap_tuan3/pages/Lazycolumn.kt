package com.example.bai_tap_tuan3.pages

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bai_tap_tuan3.layout.Header

@Composable
fun Layzycolumn(navController: NavController) {
    val backgroundCard = Color(0xFF9EDAF8)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 50.dp, end = 20.dp, start = 20.dp, bottom = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header("LazyColumn", navController = navController)
        LazyColumn(){
            items(1000000){
                index ->   itemne(index,"hello","detail",backgroundCard, navController = navController)
            }
        }


    }
}
@Composable
fun itemne(index: Int, noiDung:String, url:String, backgroundCard: Color, navController: NavController){
    Card (modifier = Modifier.fillMaxWidth().padding(all = 5.dp).clickable{navController.navigate("$url")},
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundCard
        )){
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
            Row{
                Text(text = "$index |")
                Text((noiDung))
            }

            Icon(imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = "Chi tiet",
                tint=Color(0xFFFFFFFF),
                modifier = Modifier.size(40.dp).background(color = Color.Black).clip(shape = RoundedCornerShape(8.dp))
            )
        }

    }
}