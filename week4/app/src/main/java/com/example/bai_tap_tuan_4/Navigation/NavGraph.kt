package com.example.bai_tap_tuan_4.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bai_tap_tuan_4.Pages.CreateBook
import com.example.bai_tap_tuan_4.Pages.Home
import com.example.bai_tap_tuan_4.Pages.ListBooks
import com.example.bai_tap_tuan_4.Pages.Student



@Composable
fun NavGraph(navController : NavHostController,modifier: Modifier = Modifier){
    NavHost(navController = navController, startDestination = Screen.Home){

        composable(Screen.Home) {
            Home(navController = navController)
        }
        composable (Screen.ListBooks){
            ListBooks(navController = navController)
        }
        composable(Screen.Student) {
            Student(navController = navController)
        }
        composable(Screen.CreateBook) {
            CreateBook(navController=navController)
        }
    }

}
