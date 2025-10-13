package com.example.bai_tap_tuan3.navigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bai_tap_tuan3.pages.ColumnLayout
import com.example.bai_tap_tuan3.pages.ComponentList
import com.example.bai_tap_tuan3.pages.Images
import com.example.bai_tap_tuan3.pages.RowLayout
import com.example.bai_tap_tuan3.pages.TextDetail
import com.example.bai_tap_tuan3.pages.TextField
import com.example.bai_tap_tuan3.ui.screens.HomeScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable ("componentlist" ){
            ComponentList(navController =navController)
        }
        composable("textdetail"){
            TextDetail(navController = navController)
        }
        composable ("images"){
            Images(navController = navController)
        }
        composable("textfield") {
            TextField(navController =navController)
        }
        composable("rowlayout") {
            RowLayout(navController = navController)
        }
        composable("columnlayout") {
            ColumnLayout(navController = navController)
        }
    }
}