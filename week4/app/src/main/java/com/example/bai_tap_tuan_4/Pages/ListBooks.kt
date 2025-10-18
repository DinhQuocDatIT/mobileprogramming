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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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

object Categorys{
    const val romance ="Ngôn tình"
    const val reference ="Tham khảo"
}
@Composable
fun ListBooks(navController: NavController){
    val listBook = remember { mutableStateListOf<Book>() }
    var id by remember { mutableStateOf("") }
    var nameBook by remember { mutableStateOf("") }
    var messageCreate by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var category by remember {mutableStateOf("")}


    Column(modifier = Modifier.fillMaxSize().background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Quản lý sách", fontSize = 30.sp, fontWeight = FontWeight.Bold,
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
                placeholder = {Text("Nhập mã sách")},
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                )
            )
            OutlinedTextField(
               value = nameBook,
               onValueChange = { nameBook = it },
              placeholder = {Text("Nhập tên sách")},
               shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            )
           )
            Box{
                Row (modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically){
                    Button(onClick = {expanded = !expanded},
                        modifier = Modifier.padding(10.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFFFFF)
                        )) {
                        Text(("Chọn thể loại"),fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F51B5))
                    }
                    Text(("$category"),fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(
                        0xFF000000
                    )
                    )
                }

                DropdownMenu(
                    expanded=expanded,
                    onDismissRequest = {expanded =false}
                ){
                    DropdownMenuItem(
                        text ={Text("Ngôn tình")},
                        onClick = {
                            category= Categorys.romance
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text ={Text("Tham khảo")},
                        onClick = {
                            category= Categorys.reference
                            expanded = false
                        }
                    )
                }
            }



            Button(onClick = {

                var _id = id.toIntOrNull()

                if(nameBook =="" || _id ==null){
                    messageCreate="Vui lòng nhập đầy đủ thông tin"
                }
                else if(category ==""){
                    messageCreate="Vui lòng chọn thể loại"
                }
                else{
                    if(category == Categorys.reference){
                        listBook.add(ReferenceBook(_id,nameBook,false))
                    }
                    else if(category == Categorys.romance)
                    {
                        listBook.add(RomanceBook(_id,nameBook,false))
                    }

                    messageCreate="Thêm thành công"
                    id=""
                    nameBook=""
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


            items(listBook){
                    book -> Row(modifier = Modifier.fillMaxWidth().shadow(8.dp).clip(shape = RoundedCornerShape(10.dp)).background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically){
                Checkbox(
                    checked = book.isBorrowed,
                    onCheckedChange = {
                       checked ->
                        val index = listBook.indexOf(book)
                      if(index != -1){
                          listBook[index] = ReferenceBook(book.id, book.nameBook, checked)
                      }
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFC03A3A),
                        uncheckedColor = Color.Blue,
                        checkmarkColor = Color.White
                    )
                )
                Text(text = "${book.nameBook} , thể loại ${book.categoryBook()}")

            }
            }

        }


    }
}
