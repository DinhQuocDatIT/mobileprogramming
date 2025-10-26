package com.example.bai_tap_tuan_4.Pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.runtime.*
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
import com.example.bai_tap_tuan_4.ViewModule.BookViewModel

object Categorys {
    const val romance = "Ngôn tình"
    const val reference = "Tham khảo"
}

@Composable
fun ListBooks(viewModel: BookViewModel, navController: NavController) {
    var id by remember { mutableStateOf("") }
    var nameBook by remember { mutableStateOf("") }
    var messageCreate by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var category by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Quản lý sách",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 80.dp, bottom = 20.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp, 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = id,
                onValueChange = { id = it },
                placeholder = { Text("Nhập mã sách") },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                )
            )

            OutlinedTextField(
                value = nameBook,
                onValueChange = { nameBook = it },
                placeholder = { Text("Nhập tên sách") },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                )
            )

            Box {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { expanded = !expanded },
                        modifier = Modifier.padding(10.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text("Chọn thể loại", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F51B5))
                    }
                    Text(category, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Ngôn tình") },
                        onClick = {
                            category = Categorys.romance
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Tham khảo") },
                        onClick = {
                            category = Categorys.reference
                            expanded = false
                        }
                    )
                }
            }

            Button(
                onClick = {
                    val _id = id.toIntOrNull()
                    if (nameBook == "" || _id == null) {
                        messageCreate = "Vui lòng nhập đầy đủ thông tin"
                    } else if (category == "") {
                        messageCreate = "Vui lòng chọn thể loại"
                    } else {
                        val newBook = when (category) {
                            Categorys.reference -> ReferenceBook(_id, nameBook, false)
                            Categorys.romance -> RomanceBook(_id, nameBook, false)
                            else -> ReferenceBook(_id, nameBook, false)
                        }
                        viewModel.addBook(newBook) // Thêm trực tiếp vào viewModel
                        messageCreate = "Thêm thành công"
                        id = ""
                        nameBook = ""
                        category = ""
                    }
                },
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5))
            ) {
                Text("Thêm", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }

            Text(messageCreate)
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(start = 30.dp, end = 30.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = Color(0xFFFFFAD6))
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(viewModel.bookList) { book ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(8.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = book.isBorrowed,
                        onCheckedChange = { checked ->
                            viewModel.updateBookStatus(book.id, checked) // cập nhật trạng thái qua ViewModel
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFFC03A3A),
                            uncheckedColor = Color.Blue,
                            checkmarkColor = Color.White
                        )
                    )
                    Text("${book.nameBook}, thể loại ${book.categoryBook()}")
                }
            }
        }
    }
}