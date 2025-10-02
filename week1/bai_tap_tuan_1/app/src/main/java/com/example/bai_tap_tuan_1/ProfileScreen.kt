package com.example.bai_tap_tuan_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Profile(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(393.dp)
            .requiredHeight(852.dp)
            .background(Color.White)
    ) {
        // nút back
        IconButton(
            onClick = { /* back */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(30.dp, 40.dp)
                .requiredSize(48.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .border(1.5.dp, Color(0xFFCDCDCD), RoundedCornerShape(8.dp))
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF757575)
            )
        }

        // nút edit
        IconButton(
            onClick = { /* edit */ },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset((-30).dp, 40.dp)
                .requiredSize(48.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .border(1.5.dp, Color(0xFFCDCDCD), RoundedCornerShape(8.dp))
        ) {
            Icon(
                imageVector = Icons.Outlined.Edit,
                contentDescription = "Edit",
                tint = Color(0xFF03A9A9)
            )
        }

        // avatar
        Image(
            painter = painterResource(id = R.drawable.ellipse1),
            contentDescription = "Ellipse 1",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 223.dp)
                .requiredSize(150.dp)
                .clip(CircleShape)
                .border(0.5.dp, Color(0xFF03A9A9), CircleShape)
        )

        // tên
        Text(
            text = "Đinh Quốc Đạt",
            color = Color.Black,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 402.dp)
        )

        // địa chỉ
        Text(
            text = "Mang Yang, Gia Lai",
            color = Color.Black,
            style = TextStyle(fontSize = 16.sp),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 440.dp)
        )
    }
}

@Preview(widthDp = 393, heightDp = 852, showBackground = true)
@Composable
private fun ProfilePreview() {
    Profile()
}
