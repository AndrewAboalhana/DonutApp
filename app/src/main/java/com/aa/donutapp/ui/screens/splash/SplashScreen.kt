package com.aa.donutapp.ui.screens.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aa.donutapp.R
import com.aa.donutapp.ui.theme.Inter
import com.aa.donutapp.ui.theme.OnPrimary
import com.aa.donutapp.ui.theme.Surface
import com.aa.donutapp.ui.theme.SurfaceVariant
import com.aa.donutapp.ui.theme.textSize18
import com.aa.donutapp.ui.theme.textSize20

@Composable
fun SplashScreen(
    navController: NavController,
) {
    SplashContent {
        navController.navigate("home screen")
    }
}

@Composable
private fun SplashContent(
    onClick : () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition()

    val donutOffset by infiniteTransition.animateFloat(
        initialValue = -50f,
        targetValue = 50f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Surface),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Gonuts\nwith\nDonuts",
                fontSize = 54.sp,
                fontFamily = Inter,
                lineHeight = 54.sp,
                fontWeight = FontWeight.Bold,
                color = OnPrimary,
                modifier = Modifier
                    .padding(start = 16.dp, top = 344.dp)
                    .align(Start)
            )
            Text(
                text = "Gonuts with Donuts is a Sri Lanka dedicated food outlets for specialize manufacturing of Donuts in Colombo, Sri Lanka.",
                fontSize = textSize18,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold,
                color = SurfaceVariant,
                letterSpacing = 0.7.sp ,
                modifier = Modifier.padding(start = 16.dp,
                top = 24.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onClick,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 34.dp)
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(
                    text = "Get Started",
                    fontSize = textSize20,
                    fontFamily = Inter,
                    fontWeight = FontWeight(600),
                    color = Color.Black
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.donuts),
            contentDescription = "Donuts",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .offset(y = donutOffset.dp)
        )
    }
}

