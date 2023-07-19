package com.aa.donutapp.ui.screens.home_screen.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aa.donutapp.R
import com.aa.donutapp.ui.screens.home_screen.DonutsUiState
import com.aa.donutapp.ui.theme.Background
import com.aa.donutapp.ui.theme.Inter
import com.aa.donutapp.ui.theme.OnPrimary
import com.aa.donutapp.ui.theme.Secondary
import com.aa.donutapp.ui.theme.textSize14

@Composable
fun DonutCard(
    scrollState: LazyListState,
    state: DonutsUiState,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.size(width = 138.dp, height = 167.dp)
    ) {
        Column(
            modifier = Modifier.size(138.dp,111.dp)
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 10.dp, bottomEnd = 10.dp))
                .background(Background)
                .align(BottomCenter)
                .clickable (onClick = onClick)
        ) {
            Text(
                text = state.title,
                fontSize = textSize14,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                color = Secondary,
                modifier = Modifier.align(CenterHorizontally)
                    .padding(top = 42.dp)
            )

            Text(
                text = state.price,
                fontSize = textSize14,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold,
                color = OnPrimary,
                modifier = Modifier.align(CenterHorizontally)
                    .padding(top = 10.dp)
            )
        }
        val donutRotationAngle by animateFloatAsState(
            targetValue =  if (scrollState.isScrollInProgress) 360f else 0f,
            animationSpec = tween(700)
        )
        Image(
            painter = painterResource(id = state.image),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(width = 104.dp, height = 112.dp)
                .align(TopCenter)
                .rotate(donutRotationAngle)
        )
    }


}



//@Preview
//@Composable
//fun PreviewDonutCard() {
//    val scrollState = rememberLazyListState()
//    DonutCard(scrollState)
//}