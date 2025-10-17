package com.felix.labw6_pandamart.ui.screens.foodDelivery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.felix.labw6_pandamart.navigation.Screen

@Composable
fun FoodDeliveryScreen(
    navController: NavController,
    viewModel: FoodDeliveryViewModel = viewModel(),
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Food Devlivery Screen")
        Button(onClick = {
            // Use the NavController to go to another screen
            navController.navigate(Screen.Home.route)
        }) {
            Text(text = "Home")
        }
    }
}