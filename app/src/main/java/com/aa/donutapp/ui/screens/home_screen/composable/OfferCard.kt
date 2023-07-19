package com.aa.donutapp.ui.screens.home_screen.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa.donutapp.R
import com.aa.donutapp.ui.screens.home_screen.HomeUiState
import com.aa.donutapp.ui.screens.home_screen.OffersUiState
import com.aa.donutapp.ui.theme.CardColor
import com.aa.donutapp.ui.theme.Inter
import com.aa.donutapp.ui.theme.OnPrimary
import com.aa.donutapp.ui.theme.OnSecondary
import com.aa.donutapp.ui.theme.Secondary
import com.aa.donutapp.ui.theme.Surface
import com.aa.donutapp.ui.theme.cardHeight
import com.aa.donutapp.ui.theme.cardPadding
import com.aa.donutapp.ui.theme.cardWidth
import com.aa.donutapp.ui.theme.donutHeight
import com.aa.donutapp.ui.theme.donutWidth
import com.aa.donutapp.ui.theme.expandedCardWidth
import com.aa.donutapp.ui.theme.heartIconSize
import com.aa.donutapp.ui.theme.space20
import com.aa.donutapp.ui.theme.space38
import com.aa.donutapp.ui.theme.space4
import com.aa.donutapp.ui.theme.space8
import com.aa.donutapp.ui.theme.textSize12
import com.aa.donutapp.ui.theme.textSize14
import com.aa.donutapp.ui.theme.textSize16
import com.aa.donutapp.ui.theme.textSize22

@Composable
fun OfferCardCard(
    scrollState: LazyListState,
    modifier: Modifier = Modifier,
    state: OffersUiState,
    index : Int,
    onClick: () -> Unit
) {
    val isEvenIndex = index % 2 == 0

    val cardColor = if (isEvenIndex) Surface else CardColor
    Box(
        modifier = Modifier
            .size(expandedCardWidth, cardHeight)
    ) {
        Column(
            modifier = modifier
                .clip(RoundedCornerShape(space20))
                .size(cardWidth, cardHeight)
                .background(cardColor)
                .clickable (onClick = onClick)
        ) {
            Box(
                modifier = Modifier.padding(space8),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(heartIconSize)
                        .background(Color.White, shape = CircleShape)
                )
                Icon(
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "Icon heart",
                    tint = OnPrimary,
                    modifier = Modifier.size(space20),
                )
            }

            Text(
                text = state.title,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                fontSize = textSize16,
                color = Color.Black,
                modifier = Modifier.padding(top = cardPadding, start = space8)
            )

            Spacer(modifier = Modifier.height(space8))

            Text(
                text = state.description,
                    fontSize = textSize12,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    color = Secondary,
                    letterSpacing = 0.8.sp,
                    modifier = Modifier.padding(start = space8, end = space8, bottom = space8 )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, bottom =  16.dp)
            ) {
                Row(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    verticalAlignment = CenterVertically
                ) {
                    Text(
                        text = "$${state.price}",
                        fontSize = textSize14,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Gray,
                        textDecoration = TextDecoration.LineThrough,
                        modifier = Modifier.padding(end = space4)
                    )

                    Text(
                        text = "$${state.offer}",
                        fontSize = textSize22,
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }


        }

        val donutRotationAngle by animateFloatAsState(
           targetValue =  if (scrollState.isScrollInProgress) 360f else 0f,
            animationSpec = tween(700)
        )

        Image(
            painter = painterResource(id = state.image),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(donutWidth)
                .height(donutHeight)
                .offset(y = space38)
                .align(Alignment.TopEnd)
                .rotate(donutRotationAngle)
        )
    }
}






@Preview
@Composable
fun PreviewHomeCard() {
    val scrollState = rememberLazyListState()
    OfferCardCard(modifier = Modifier,scrollState = scrollState, index = 0, state = OffersUiState(
        "adssdads","asdddddddddddddddddddddddddd",R.drawable.donut,"20","16"
    ), onClick = {})
}