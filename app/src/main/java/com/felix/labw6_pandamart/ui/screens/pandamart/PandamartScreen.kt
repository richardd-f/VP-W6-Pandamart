package com.felix.labw6_pandamart.ui.screens.pandamart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.felix.labw6_pandamart.R
import com.felix.labw6_pandamart.data.DummyDataMenu
import com.felix.labw6_pandamart.model.MenuModel
import com.felix.labw6_pandamart.ui.components.MenuCard
import com.felix.labw6_pandamart.ui.components.SearchBar

@Composable
fun PandamartScreen(
    navController: NavController,
    viewModel: PandamartViewModel = viewModel()
){
    PandamartScreenContent(
        searchValue = viewModel.searchValue.collectAsState().value,
        onSearchValueChange = { viewModel.onSearchValueChange(it) },
        featuredProducts = viewModel.featuredProducts.collectAsState().value
    )
}

@Composable
fun PandamartScreenContent(
    searchValue: String,
    onSearchValueChange: (String) -> Unit,
    featuredProducts: List<MenuModel>
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD7D7D7))
    ) {
        // Top Bar
        Row (
            modifier = Modifier
                .background(Color(0xFFBE418C))
                .padding(top = 40.dp)
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(40.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "back logo",
                tint = Color.White
            )
            Text(
                text="Vegetables",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Cart logo",
                tint = Color.White
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .padding(bottom = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(vertical = 15.dp)
                    .padding(start = 15.dp),
                text ="Find Your Favorite Vegetables",
                style = MaterialTheme.typography.titleLarge
            )

            SearchBar(
                onValueChange = { onSearchValueChange(it) },
                value = searchValue,
                placeholder = "Search for Vegetables",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Seach logo"
                    )
                },
            )

            Row(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Featured Product",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(text = "View More", color = Color.Gray)
            }

            featuredProducts.chunked(2).forEach { rowItems ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // first item (always exists)
                    MenuCard(
                        modifier = Modifier.weight(1f),
                        imageRes = rowItems[0].imageRes,
                        title = rowItems[0].name,
                        price = rowItems[0].price
                    )

                    // second item (may not exist if odd count)
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

            // Image Table
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                // Background Image
                Image(
                    painter = painterResource(R.drawable.food_table),
                    contentDescription = "Food Table",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )

                // Overlay Text
                Text(
                    text = "20% off on your\nfirst purchase",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.BottomStart) 
                        .padding(start = 90.dp, bottom = 55.dp)
                )

                // like step button
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Green rounded rectangle
                    Box(
                        modifier = Modifier
                            .width(25.dp)
                            .height(8.dp)
                            .clip(RoundedCornerShape(50))
                            .background(Color(0xFF7CC74D))
                    )

                    // Three white circles
                    repeat(3) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(Color.White)
                        )
                    }
                }
            }


        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PandamartPreview(){
    PandamartScreenContent(
        searchValue = "",
        onSearchValueChange = {},
        featuredProducts = DummyDataMenu().FeaturedProduct
    )
}