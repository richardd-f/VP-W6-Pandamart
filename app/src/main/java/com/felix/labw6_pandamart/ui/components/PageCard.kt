package com.felix.labw6_pandamart.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.felix.labw6_pandamart.R

@Composable
fun PageCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    imageRes: Int,
    onCardClick: () -> Unit
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(0.75f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        onClick = {onCardClick()}
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                painter = painterResource(imageRes),
                contentDescription = "Image page:${title} Logo"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PageCardPreview(){
    PageCard(
        title = "Food Delivery",
        description = "Delivery from 99$",
        imageRes = R.drawable.burger_oke,
        onCardClick = {}
    )
}