package com.example.navigationlab

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen(navigateToSecondScreen: (String, Int) -> Unit) {
    val name = remember { mutableStateOf("") }
    val age = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is the First Screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Enter your name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = age.value,
            onValueChange = { age.value = it },
            label = { Text("Enter your age") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val ageValue = age.value.toIntOrNull() ?: 0
            navigateToSecondScreen(name.value, ageValue)
        }) {
            Text("Go to Second Screen")
        }
    }
}

@Preview
@Composable
fun FirstPreview() {
    FirstScreen { _, _ -> }
}