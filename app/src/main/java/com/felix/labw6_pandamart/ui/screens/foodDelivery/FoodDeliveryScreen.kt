package com.felix.labw6_pandamart.ui.screens.foodDelivery

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.felix.labw6_pandamart.R
import com.felix.labw6_pandamart.data.DummyDataMenu
import com.felix.labw6_pandamart.model.MenuModel
import com.felix.labw6_pandamart.ui.components.MenuCard
import com.felix.labw6_pandamart.ui.components.SearchBar

@Composable
fun FoodDeliveryScreen(
    navController: NavController,
    viewModel: FoodDeliveryViewModel = viewModel(),
){
    FoodDeliveryScreenContent(
        popularMenus = viewModel.popularMenus.collectAsState().value,
        searchValue = viewModel.searchValue.collectAsState().value,
        onSearchValueChange = { viewModel.onSearchValueChange(it) }
    )
}

@Composable
fun FoodDeliveryScreenContent(
    popularMenus: List<MenuModel>,
    searchValue: String,
    onSearchValueChange: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD7D7D7))
            .padding(top = 40.dp),
        contentPadding = PaddingValues(horizontal = 30.dp)
    ) {

        item {
            // Top Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.width(200.dp),
                    text = "Find Your Favorite Food",
                    style = MaterialTheme.typography.headlineMedium,
                )
                Image(
                    modifier = Modifier.width(150.dp).height(140.dp),
                    painter = painterResource(R.drawable.food_delivery_logo),
                    contentDescription = "Bear Logo"
                )
            }
        }

        item {
            // Search Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SearchBar(
                    modifier = Modifier.weight(1f),
                    onValueChange = { onSearchValueChange(it) },
                    value = searchValue,
                    placeholder = "Search for Food",
                    leadingIcon = {
                        Icon(
                            modifier = Modifier.padding(start = 10.dp),
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search logo"
                        )
                    },
                    trailingIcon = {
                        Image(
                            modifier = Modifier.width(30.dp),
                            painter = painterResource(R.drawable.setting),
                            colorFilter = ColorFilter.tint(Color.White),
                            contentDescription = "Setting logo"
                        )
                    }
                )
                Icon(
                    modifier = Modifier.width(70.dp).height(50.dp),
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Logo Notif",
                    tint = Color(0xFFD73C78),
                )
            }
        }

        item {
            // Special Deal
            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .background(Color(0xFFD73C78))
                    .padding(start = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(0.5f)) {
                    Text(
                        text = "Special Deal For December",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color(0xFFD73C78)
                        ),
                    ) {
                        Text(text = "Buy Now", style = MaterialTheme.typography.titleMedium)
                    }
                }
                Image(
                    modifier = Modifier.weight(0.4f),
                    painter = painterResource(R.drawable.ice_creams),
                    contentDescription = "Ice Creams"
                )
            }
        }

        item {
            // Popular Menu Header
            Row(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Popular Menu",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(text = "View More", color = Color.Gray)
            }
        }

        // --- Grid Section ---
        items(popularMenus.chunked(2)) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                MenuCard(
                    modifier = Modifier.weight(1f),
                    imageRes = rowItems[0].imageRes,
                    title = rowItems[0].name,
                    price = rowItems[0].price
                )

                if (rowItems.size > 1) {
                    MenuCard(
                        modifier = Modifier.weight(1f),
                        imageRes = rowItems[1].imageRes,
                        title = rowItems[1].name,
                        price = rowItems[1].price
                    )
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FoodDeliveryScreenPreview(){
    FoodDeliveryScreenContent(
        popularMenus = DummyDataMenu().PopularMenu,
        searchValue = "",
        onSearchValueChange = {}
    )
}