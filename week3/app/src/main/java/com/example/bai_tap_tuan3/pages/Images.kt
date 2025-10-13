package com.example.bai_tap_tuan3.pages

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bai_tap_tuan3.layout.Header
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.example.bai_tap_tuan3.R

@Composable
fun Images(navController: NavController){
    val imageUrl ="https://s.cmx-cdn.com/giaothongvantaitphcm.edu.vn/wp-content/uploads/2024/06/ky-niem-36-nam-thanh-lap-truong-dai-hoc-giao-thong-van-tai-tphcm-560px.jpg"
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize().padding(top=20.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.Start,
    ){
        Header("Images",navController = navController)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            AsyncImage(
                model=imageUrl,
                contentDescription = "Anh URL UTH",
                modifier = Modifier.fillMaxWidth().height(200.dp).clip(RoundedCornerShape(16.dp)),

            )
            Text(text = imageUrl,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    // Mở đường link ảnh trên trình duyệt
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(imageUrl))
                    context.startActivity(intent)
                })
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(painter = painterResource(id=R.drawable.uth),
                contentDescription = "ảnh tại máy",
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(RoundedCornerShape(16.dp)))
            Text("Tại máy")
        }
    }

}
