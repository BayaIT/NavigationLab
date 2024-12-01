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
fun ThirdScreen(navigateToFirstScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is the Third Screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = navigateToFirstScreen) {
            Text("Go to First Screen")
        }
    }
}

@Preview
@Composable
fun ThirdPreview() {
    ThirdScreen {}
}