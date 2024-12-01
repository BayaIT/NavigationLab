package com.example.navigationlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "firstscreen") {
        composable("firstscreen") {
            FirstScreen { name, age ->
                navController.navigate("secondscreen/$name/$age")
            }
        }
        composable("secondscreen/{name}/{age}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: "Unknown"
            val age = backStackEntry.arguments?.getString("age")?.toIntOrNull() ?: 0
            SecondScreen(name, age) {
                navController.navigate("thirdscreen")
            }
        }
        composable("thirdscreen") {
            ThirdScreen {
                navController.navigate("firstscreen") {
                    popUpTo("firstscreen") { inclusive = true }
                }
            }
        }
    }
}