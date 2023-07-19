package com.aa.donutapp.ui.screens.home_screen

import androidx.lifecycle.ViewModel
import com.aa.donutapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class HomeViewModel: ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()


    init {
        getOffers()
        getDonuts()
    }


    private fun getOffers(){
        _state.update {
            it.copy(offers = listOf(
                OffersUiState(
                    "Chocolate Glaze",
                    "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                    image = R.drawable.donut,
                    offer = "16",
                    price = "20"
                ), OffersUiState(
                    "Strawberry Wheel",
                    "These Baked Strawberry Donuts are filled with fresh strawberries...",
                    image = R.drawable.donut,
                    offer = "16",
                    price = "20"
                ),OffersUiState(
                    "Chocolate Glaze",
                    "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                    image = R.drawable.donut,
                    offer = "16",
                    price = "20"
                ),OffersUiState(
                    "Strawberry Wheel",
                    "These Baked Strawberry Donuts are filled with fresh strawberries...",
                    image = R.drawable.donut,
                    offer = "16",
                    price = "20"
                ),OffersUiState(
                    "Chocolate Glaze",
                    "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                    image = R.drawable.donut,
                    offer = "16",
                    price = "20"
                ),

            ))
        }
    }

    private fun getDonuts(){
        _state.update {
            it.copy(
                donuts = listOf(
                    DonutsUiState(
                        "Chocolate Cherry",
                        image = R.drawable.donut2,
                        price = "$22"
                    ),DonutsUiState(
                        "Strawberry Rain",
                        image = R.drawable.donut1,
                        price = "$22"
                    ),DonutsUiState(
                        "Strawberry ",
                        image = R.drawable.donut3,
                        price = "$22"
                    ),DonutsUiState(
                        "Chocolate Cherry",
                        image = R.drawable.donut2,
                        price = "$22"
                    ),DonutsUiState(
                        "Strawberry Rain",
                        image = R.drawable.donut1,
                        price = "$22"
                    ),
                )
            )
        }
    }
}