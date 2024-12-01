package com.example.navigationlab

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(name: String, age: Int, navigateToThirdScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hello $name, you are $age years old", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = navigateToThirdScreen) {
            Text("Go to Third Screen")
        }
    }
}

@Preview
@Composable
fun SecondPreview() {
    SecondScreen("Alex", 25) {}
}