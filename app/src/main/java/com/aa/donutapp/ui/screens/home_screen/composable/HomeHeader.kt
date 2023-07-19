package com.aa.donutapp.ui.screens.home_screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aa.donutapp.R
import com.aa.donutapp.ui.theme.Inter
import com.aa.donutapp.ui.theme.OnPrimary
import com.aa.donutapp.ui.theme.Primary
import com.aa.donutapp.ui.theme.Secondary
import com.aa.donutapp.ui.theme.textSize14
import com.aa.donutapp.ui.theme.textSize32

@Composable
fun HomeHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 48.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextHeader()

        Box(
            Modifier
                .width(45.dp)
                .height(45.dp)
                .background(color = Primary, shape = RoundedCornerShape(size = 15.dp))
        ) {
            Icon(painter = painterResource(id = R.drawable.search),
                contentDescription = "Search icon",
                tint = OnPrimary,
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}

@Composable
private fun TextHeader(){
    Column() {

        Text(
            text = "Let’s Gonuts!",
                fontSize = textSize32,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold,
                color = OnPrimary,
            )
        Text(
            text = "Order your favourite donuts from here",
                fontSize = textSize14,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                color = Secondary,
            )

    }
}

@Preview
@Composable
fun PreviewHomeHeader() {
    HomeHeader()
}

@Preview
@Composable
fun PreviewTextHeader() {
    TextHeader()
}