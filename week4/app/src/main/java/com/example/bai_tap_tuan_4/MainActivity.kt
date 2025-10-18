package com.example.bai_tap_tuan_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.bai_tap_tuan_4.Navigation.BottomNavigationBar
import com.example.bai_tap_tuan_4.Navigation.NavGraph
import com.example.bai_tap_tuan_4.ui.theme.Bai_tap_tuan_4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bai_tap_tuan_4Theme {
                    MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavGraph(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Bai_tap_tuan_4Theme {

    }
}