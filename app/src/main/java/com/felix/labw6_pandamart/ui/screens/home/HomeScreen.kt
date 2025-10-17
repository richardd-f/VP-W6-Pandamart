package com.felix.labw6_pandamart.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.felix.labw6_pandamart.R
import com.felix.labw6_pandamart.navigation.Screen
import com.felix.labw6_pandamart.ui.components.PageCard
import com.felix.labw6_pandamart.ui.components.SearchBar

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = viewModel()
) {
    HomeScreenContent(
        searchValue = viewModel.searchValue.collectAsState().value,
        onSearchValueChange = { viewModel.onSearchValueChange(it) },
        navActiveBtnIndex = viewModel.navActiveBtnIndex.collectAsState().value,
        optionsNavBtn = viewModel.optionsNavBtn,
        onNavBtnClick = { viewModel.onNavBtnClick(it) },
        navController = navController
    )
}

@Composable
fun HomeScreenContent(
    searchValue: String,
    onSearchValueChange: (String) -> Unit,
    navActiveBtnIndex: Int,
    optionsNavBtn: List<String>,
    onNavBtnClick: (Int) -> Unit = {},
    navController: NavController
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD7D7D7)),
        contentAlignment = Alignment.Center,
    ){
        Column(
            modifier = Modifier
                .padding(top = 60.dp)
                .fillMaxHeight()
                .fillMaxWidth(0.9f),
            verticalArrangement = Arrangement.Center
        ) {
            // Top Container
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                // Tag Line
                Text(
                    modifier = Modifier
                        .width(220.dp),
                    text = "Taste the world at your Door Step!",
                    style = MaterialTheme.typography.headlineMedium,
                )
                // Bear Logo
                Image(
                    modifier = Modifier
                        .width(60.dp),
                    painter = painterResource(R.drawable.bear_logo),
                    contentDescription = "Bear Logo"
                )
            }

            // Search Bar
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth(),
                value = searchValue,
                onValueChange = {onSearchValueChange(it)},
                placeholder = "What are you craving?",
                leadingIcon = {
                    Spacer(modifier = Modifier.width(0.dp))
                },
                trailingIcon = {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = Color.White
                    )
                }
            )

            // Button Hamburger
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.Start
            ) {
                optionsNavBtn.forEachIndexed{ index, text ->
                    navButton(
                        onClick = { onNavBtnClick(index) },
                        text = text,
                        isActive = (index == navActiveBtnIndex)
                    )
                    Spacer(Modifier.width(10.dp))
                }
            }

            // Page Card
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
            ) {
                PageCard(
                    title = "Food Delivery",
                    description = "Delivery from $99",
                    imageRes = R.drawable.burger_oke,
                    modifier = Modifier.weight(1f),
                    onCardClick = {navController.navigate(Screen.FoodDelivery.route)}
                )
                Spacer(Modifier.width(10.dp))
                PageCard(
                    title = "Pandamart",
                    description = "new user $10 off",
                    imageRes = R.drawable.bear_cart,
                    modifier = Modifier.weight(1f),
                    onCardClick = {navController.navigate(Screen.Pandamart.route)}
                )
            }

            // Bottom Part
            Text(
                modifier = Modifier.padding(top = 20.dp, bottom = 10.dp),
                text = "Restauran Available Now!",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(R.drawable.pizza),
                contentDescription = "Pizza",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
                    .height(250.dp),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

// Reuseable Composable for Home Screen only
@Composable
fun navButton(
    onClick: () -> Unit,
    text: String,
    isActive: Boolean,
){
    Button(
        modifier = Modifier,
        onClick = {onClick()},
        colors = ButtonDefaults.buttonColors(
            containerColor = if(isActive) Color(0xFFC36EA5)
                else Color(0xFFD2C3CD),
            contentColor = if(isActive) Color.White
                else Color(0xFFC475A6)
        ),
        contentPadding = PaddingValues(horizontal = 28.dp)
    ) {
        Text(text = text)
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreenContent(
        searchValue = "",
        onSearchValueChange = {},
        navActiveBtnIndex = 0,
        optionsNavBtn = listOf("Restaurants", "Deals", "Track Order", "Deals", "Track Order"),
        onNavBtnClick = {  },
        navController = rememberNavController()
    )
}