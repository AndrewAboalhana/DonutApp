package com.aa.donutapp.ui.screens.details_screen

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.donutapp.R
import com.aa.donutapp.ui.screens.details_screen.composable.BottomSheet
import com.aa.donutapp.ui.theme.OnPrimary
import com.aa.donutapp.ui.theme.Primary
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun DetailsScreen(
    navController: NavController,
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    DetailsContent(
        state = state,viewModel,
        onClick = {
            navController.navigate("home screen")
        }
    )
}


@Composable
private fun DetailsContent (
    state: DetailsUiState,
    viewModel: DetailsViewModel,
    onClick: () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    val systemUiController = rememberSystemUiController()
    val isDarkTheme = isSystemInDarkTheme()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = !isDarkTheme
        )
    }

    LazyColumn(){
        item {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "Back",
            tint = OnPrimary,
            modifier = Modifier.padding(top = 48.dp, start = 24.dp)
                .clickable (onClick = onClick)
        )

        Image(
            painter = painterResource(id = R.drawable.details_donut),
            contentDescription = "Donut",
            modifier = Modifier
                .align(CenterHorizontally)
                .width(400.dp)
                .height(300.dp)
                .rotate(rotation)
        )
        Spacer(modifier = Modifier.weight(1f))
        BottomSheet(state,viewModel)

    }
        }
    }
}

//@Preview
//@Composable
//fun PreviewDetailsScreen() {
//    DetailsContent(state = )
//}