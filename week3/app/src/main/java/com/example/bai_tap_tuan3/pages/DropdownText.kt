package com.example.bai_tap_tuan3.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bai_tap_tuan3.layout.Header

@Composable
fun DropdownText(navController: NavController){
    var expanded by remember { mutableStateOf(false) }
    var option by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(top=20.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.Start,
    ){
        Header("Dropdown Text",navController = navController)
    Column(modifier = Modifier.padding(bottom = 20.dp)) {
        Icon(imageVector = Icons.Outlined.MoreVert,
            contentDescription = "Menu",
            tint = Color(0xFF03A9F4),
            modifier = Modifier.clickable{
                expanded = true
            })
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Xin chào") },
                onClick = { option="Xin chào mọi người"
                    expanded = false}
            )
            DropdownMenuItem(
                text = { Text("Chào") },
                onClick = { option="xin chào thế giới"
                    expanded = false}
            )

        }
    }
        Text((option))
    }

}
