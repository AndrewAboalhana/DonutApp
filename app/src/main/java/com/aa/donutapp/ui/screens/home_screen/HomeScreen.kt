package com.aa.donutapp.ui.screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.donutapp.R
import com.aa.donutapp.ui.Composable.VerticalSpacer
import com.aa.donutapp.ui.screens.home_screen.composable.DonutCard
import com.aa.donutapp.ui.screens.home_screen.composable.HomeHeader
import com.aa.donutapp.ui.screens.home_screen.composable.HomeNavBar
import com.aa.donutapp.ui.screens.home_screen.composable.OfferCardCard
import com.aa.donutapp.ui.theme.Background
import com.aa.donutapp.ui.theme.CardColor
import com.aa.donutapp.ui.theme.Inter
import com.aa.donutapp.ui.theme.Surface
import com.aa.donutapp.ui.theme.space20
import com.aa.donutapp.ui.theme.textSize20

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    HomeContent(
        state = state,
        onCLick = {navController.navigate("details screen")}
    )
}


@Composable
private fun HomeContent (
    state: HomeUiState,
    onCLick: () -> Unit
) {
    val offersState = rememberLazyListState()
    val donutsState = rememberLazyListState()
    LazyColumn(){
    item {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
        ) {
            HomeHeader()
            VerticalSpacer(space = 54.dp)
            Text(
                text = "Today Offers",
                fontSize = textSize20,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier.padding(start = 16.dp)
            )
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                state = offersState
            ) {
                itemsIndexed(state.offers) { index, offer ->
                    OfferCardCard(
                        scrollState = offersState,
                        state = offer,
                        index = index,
                        onClick = onCLick

                    )
                }
            }

            VerticalSpacer(space = 46.dp)

            Text(
                text = "Donuts",
                fontSize = textSize20,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier.padding(start = 16.dp)
            )
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                state = donutsState
            ) {
                items(state.donuts) {
                    DonutCard(
                        scrollState = donutsState,
                        state = it,
                        onClick = onCLick
                    )
                }
            }
            HomeNavBar()
        }
    }
    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun PreviewHomeScreen() {
//    HomeContent()
//}