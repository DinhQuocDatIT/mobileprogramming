package com.example.bai_tap_tuan_4.Pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bai_tap_tuan_4.Entity.Book
import com.example.bai_tap_tuan_4.Entity.ReferenceBook
import com.example.bai_tap_tuan_4.Entity.RomanceBook
import com.example.bai_tap_tuan_4.Entity.Student
import com.example.bai_tap_tuan_4.ViewModule.StudentViewModule

@Composable
fun Student(viewModel : StudentViewModule,navController: NavController){
    var listStudent = remember { mutableStateListOf<Student>() }
    var id by remember { mutableStateOf("") }
    var nameStudent by remember { mutableStateOf("") }
    var messageCreate by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize().background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Quản lý sinh viên", fontSize = 30.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top=80.dp, bottom = 20.dp))
        Column(modifier = Modifier.fillMaxWidth().padding(30.dp,10.dp).clip(shape = RoundedCornerShape(10.dp)).background(color = Color(
            0xFFFFFFFF
        )
        ).padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = id,
                onValueChange = { id = it },
                placeholder = {Text("Nhập mã sinh viên")},
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                )
            )
            OutlinedTextField(
                value = nameStudent,
                onValueChange = { nameStudent = it },
                placeholder = {Text("Nhập tên sinh viên")},
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                )
            )
            Button(onClick = {

                var _id = id.toIntOrNull()

                if(nameStudent =="" || _id ==null){
                    messageCreate="Vui lòng nhập đầy đủ thông tin"
                }
                else{
                    viewModel.addStudent(Student(_id,nameStudent))
                    messageCreate="Thêm thành công"
                    id=""
                    nameStudent=""
                }

            },

                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3F51B5)
                )) {

                Text(text = "Thêm", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            Text((messageCreate))
        }
        LazyColumn(modifier = Modifier.fillMaxWidth().height(250.dp)
            .padding( start = 30.dp, end = 30.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color(0xFFFFFAD6))
            .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)){


            items(viewModel.studentList){
                    student -> Row(modifier = Modifier.fillMaxWidth().shadow(8.dp).clip(shape = RoundedCornerShape(10.dp)).background(color = Color.White).padding(end = 10.dp, start = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "${student.nameStudent} ", modifier = Modifier.weight(1f),fontSize = 20.sp)
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Chi tiết",
                        tint = Color(0xFF3F51B5)
                    )
                }

            }
            }

        }
    }
}