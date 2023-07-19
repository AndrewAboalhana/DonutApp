package com.aa.donutapp.ui.screens.home_screen.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aa.donutapp.R
import com.aa.donutapp.ui.theme.OnPrimary

@Composable
fun HomeNavBar() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 34.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = R.drawable.home),
            contentDescription = "home",
            tint = OnPrimary
        )
        Icon(painter = painterResource(id = R.drawable.heart_nav),
            contentDescription = "home",
            tint = OnPrimary
        )
        Icon(painter = painterResource(id = R.drawable.notification),
            contentDescription = "home",
            tint = OnPrimary
        )
        Icon(painter = painterResource(id = R.drawable.buy),
            contentDescription = "home",
            tint = OnPrimary
        )
        Icon(painter = painterResource(id = R.drawable.profile),
            contentDescription = "home",
            tint = OnPrimary
        )

    }
}


@Preview
@Composable
fun PreviewHomeNavBar() {
    HomeNavBar()
}