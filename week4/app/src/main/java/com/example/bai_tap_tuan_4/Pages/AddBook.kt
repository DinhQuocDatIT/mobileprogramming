package com.example.bai_tap_tuan_4.Pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bai_tap_tuan_4.ViewModule.BookViewModel

@Composable
fun AddBook(viewModel: BookViewModel, navController: NavController){
    LazyColumn(modifier = Modifier.fillMaxWidth().height(300.dp)
        .padding(top=10.dp)
        .clip(shape = RoundedCornerShape(10.dp))
        .background(color = Color(0xFFE1E1E1))
        .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)){

        items(viewModel.bookList){
                index -> Row(modifier = Modifier.fillMaxWidth().shadow(8.dp).clip(shape = RoundedCornerShape(10.dp)).background(color = Color.White),
            verticalAlignment = Alignment.CenterVertically){

            Text(text = "uuu")

        }
        }

    }
}