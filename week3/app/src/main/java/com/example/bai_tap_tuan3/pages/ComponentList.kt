package com.example.bai_tap_tuan3.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.KeyEventDispatcher
import androidx.navigation.NavController
import com.example.bai_tap_tuan3.layout.Header

@Composable
fun ComponentList(
    navController: NavController
){
    val backgroundCard = Color(0xFF9EDAF8)
    Column(
        modifier = Modifier.fillMaxSize().padding(top=20.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Header("UI Component List",navController = navController)
        Column (verticalArrangement = Arrangement.spacedBy(10.dp)){
            Text("Display", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            cardCustom("Text","Displays text","home",backgroundCard,navController = navController)
            cardCustom("Image","Displays an image","home",backgroundCard,navController = navController)
        }
        Column (verticalArrangement = Arrangement.spacedBy(10.dp)){
            Text("Input", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            cardCustom("TextField","Input field for text","home",backgroundCard,navController = navController)
            cardCustom("PasswordField","Input field for passwords","home",backgroundCard,navController = navController)
        }
        Column (verticalArrangement = Arrangement.spacedBy(10.dp)){
            Text("Layout", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            cardCustom("Column","Arranges elements vertically","home",backgroundCard,navController = navController)
            cardCustom("Row","Arranges elements horizontally","home",backgroundCard,navController = navController)
        }


    }

}
@Composable
fun cardCustom(tieuDe: String, noiDung:String, url:String, backgroundCard: Color, navController: NavController){

    Card (modifier = Modifier.fillMaxWidth().padding(start = 10.dp).clickable{navController.navigate("$url")},
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundCard
        )){
        Column(modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp, start = 15.dp)) {
            Text(text=(tieuDe), color = Color.Black ,fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = (noiDung), color = Color.Black,fontSize = 18.sp)
        }

    }
}
