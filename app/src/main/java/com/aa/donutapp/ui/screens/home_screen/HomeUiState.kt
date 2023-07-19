package com.aa.donutapp.ui.screens.home_screen


data class HomeUiState(
    val offers: List<OffersUiState> = mutableListOf(),
    val donuts: List<DonutsUiState> = mutableListOf()
)


data class OffersUiState(
    val title : String,
    val description : String,
    val image : Int,
    val offer : String ,
    val price : String
)

data class DonutsUiState(
    val title : String,
    val image : Int,
    val price : String
)