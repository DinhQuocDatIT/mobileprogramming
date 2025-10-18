package com.example.bai_tap_tuan_4.Pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bai_tap_tuan_4.Entity.ReferenceBook

@Composable
fun Home(navController: NavController){
    var nameStudent by remember { mutableStateOf("") }
    var check by remember { mutableStateOf(true) }
    Column (modifier = Modifier.fillMaxSize().background(color = Color.White).padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(text = "Hệ thống \n quản lý thư viện",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            lineHeight = 40.sp,
            modifier = Modifier.fillMaxWidth().padding(top = 100.dp, bottom = 100.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Sinh viên ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,)
            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                OutlinedTextField(
                    value = nameStudent,
                    onValueChange = { nameStudent = it },
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White
                    ),
                    modifier = Modifier.weight(1f)
                )
                Button(onClick = {
                },
                    modifier = Modifier.fillMaxHeight(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF3F51B5)
                    )) {

                    Text(text = "Thay đổi", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
        }
        Column(modifier = Modifier.fillMaxWidth().padding(top=30.dp)) {
            Text(text = "Danh sách sách ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,)

            LazyColumn(modifier = Modifier.fillMaxWidth().height(250.dp)
                .padding(top=10.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = Color(0xFFE1E1E1))
                .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)){


                items(10){
                        index -> Row(modifier = Modifier.fillMaxWidth().shadow(8.dp).clip(shape = RoundedCornerShape(10.dp)).background(color = Color.White),
                            verticalAlignment = Alignment.CenterVertically){
                            Checkbox(
                                checked = check,
                                onCheckedChange = {check =it},
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color(0xFFC03A3A),
                                    uncheckedColor = Color.Blue,
                                    checkmarkColor = Color.White
                                )
                            )
                            Text(text = "$index")

                }
                }

            }
            Row(modifier = Modifier.fillMaxWidth().padding(top = 15.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = {
                },
                    modifier = Modifier,
                    contentPadding = PaddingValues(35.dp,15.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF3F51B5)
                    )) {

                    Text(text = "Thêm", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }
            }


        }

    }
}