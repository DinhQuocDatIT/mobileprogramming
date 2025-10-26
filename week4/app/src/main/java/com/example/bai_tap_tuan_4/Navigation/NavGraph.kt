package com.example.bai_tap_tuan_4.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.compose.*
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bai_tap_tuan_4.Pages.CreateBook
import com.example.bai_tap_tuan_4.Pages.Home
import com.example.bai_tap_tuan_4.Pages.ListBooks
import com.example.bai_tap_tuan_4.Pages.Student
import com.example.bai_tap_tuan_4.ViewModule.BookViewModel
import com.example.bai_tap_tuan_4.ViewModule.StudentViewModule


@Composable
fun NavGraph(navController : NavHostController,modifier: Modifier = Modifier){
    val bookViewModel: BookViewModel = viewModel()
    var studentViewModule : StudentViewModule = viewModel()
    NavHost(navController = navController, startDestination = Screen.Home){

        composable(Screen.Home) {
            Home(navController = navController)
        }
        composable(Screen.ListBooks) {
            ListBooks(viewModel = bookViewModel, navController = navController)
        }
        composable(Screen.Student) {
            Student(viewModel = studentViewModule, navController = navController)
        }
        composable(Screen.CreateBook) {
            CreateBook(navController=navController)
        }
        composable(Screen.AddBook) {
            CreateBook(viewModel = bookViewModel,navController=navController)
        }
    }

}
