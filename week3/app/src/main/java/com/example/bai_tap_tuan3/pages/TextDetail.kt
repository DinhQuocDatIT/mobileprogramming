package com.example.bai_tap_tuan3.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bai_tap_tuan3.layout.Header

@Composable
fun TextDetail(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize().padding(top=20.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Header("Text Detail",navController = navController)
        Column(
            modifier = Modifier.fillMaxSize().padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(buildAnnotatedString {
                append("The ")
                withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)){
                    append("quick ")
                }
                withStyle(style = SpanStyle(
                    color = Color(0xFFB26A00),
                    fontWeight = FontWeight.Bold
                )){
                    append("Brown ")
                }
                append("fox jumps ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                    append("over ")
                }
                append("the ")
                withStyle(style = SpanStyle(fontStyle = FontStyle.Italic,
                    textDecoration = TextDecoration.Underline)){
                    append("lazy ")

                }
                append("dog.")
            },
                fontSize = 30.sp,
                lineHeight = 36.sp)
        }

    }
}