package com.felix.labw6_pandamart.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.felix.labw6_pandamart.ui.screens.foodDelivery.FoodDeliveryScreen
import com.felix.labw6_pandamart.ui.screens.home.HomeScreen
import com.felix.labw6_pandamart.ui.screens.pandamart.PandamartScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object FoodDelivery : Screen("food_delivery")
    object Pandamart : Screen("pandamart_activity")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.FoodDelivery.route) { FoodDeliveryScreen(navController) }
        composable(Screen.Pandamart.route) { PandamartScreen(navController) }
    }
}