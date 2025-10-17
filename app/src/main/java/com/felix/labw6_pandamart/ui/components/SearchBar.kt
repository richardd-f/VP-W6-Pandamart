package com.felix.labw6_pandamart.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    placeholder: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
){
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = { Text(placeholder) },
        trailingIcon = trailingIcon ,
        leadingIcon = leadingIcon,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(50)),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color(0xFFD32F7D),
            focusedContainerColor = Color(0xFFD32F7D),
            unfocusedPlaceholderColor = Color.White,
            focusedPlaceholderColor = Color.White,
            unfocusedLeadingIconColor = Color.White,
            focusedLeadingIconColor = Color.White,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White
        )
    )
}