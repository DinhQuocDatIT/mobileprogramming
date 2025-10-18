package com.example.bai_tap_tuan_4.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

data class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
)

@Composable
fun BottomNavigationBar(navController: NavController){
    val items = listOf(
        BottomNavItem(Screen.Home,"Trang chủ", Icons.Default.Home),
        BottomNavItem(Screen.ListBooks,"DS Sách",Icons.Default.DateRange),
        BottomNavItem(Screen.Student,"Sinh viên",Icons.Default.AccountCircle)
    )
    NavigationBar {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route
        items.forEach {
            item -> NavigationBarItem(selected = currentRoute==item.route, onClick = {
                if(currentRoute!=item.route){
                    navController.navigate(item.route){
                        popUpTo(Screen.Home)
                        launchSingleTop =true
                    }
                }
        },
                icon ={ Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) })
        }
    }

}