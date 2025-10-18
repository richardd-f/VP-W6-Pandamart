package com.felix.labw6_pandamart.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.felix.labw6_pandamart.R

@Composable
fun MenuCard(
    modifier: Modifier = Modifier,
    imageRes: Int,
    title: String,
    price: Int
){
    Column (
        modifier = modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(30.dp)
            )
            .aspectRatio(0.8f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = "${title} logo",
            modifier = Modifier
                .width(130.dp)
                .height(150.dp)
        )

        Text(
            text=title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp),
            text = "${price}$",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFFD73C78)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MenuCardPreview(){
    MenuCard(
        imageRes = R.drawable.burger,
        title = "Burger",
        price = 10,

    )
}