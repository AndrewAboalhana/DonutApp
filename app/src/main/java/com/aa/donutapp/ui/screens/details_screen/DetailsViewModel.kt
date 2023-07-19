package com.aa.donutapp.ui.screens.details_screen

import androidx.lifecycle.ViewModel
import com.aa.donutapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailsViewModel: ViewModel() {

    private val _state = MutableStateFlow(DetailsUiState())
    val state = _state.asStateFlow()


    init {
        getDetails()
    }

    fun addDonut() {
        val number = state.value.quantity
        val price = state.value.price
        val value = 16
        _state.update {
            it.copy(
                quantity = number + 1,
                price = price + value
            )
        }
    }

    fun reduceDonutQuantity() {
        val number = state.value.quantity
        val price = state.value.price
        val value = 16
        if (number > 1) {
            _state.update {
                it.copy(
                    quantity = number - 1,
                    price = price - value
                )
            }
        }
    }




    private fun getDetails(){
        _state.update {
            it.copy(
                image = R.drawable.details_donut,
                title = "Strawberry Wheel",
                description = "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                price = 16,
                quantity = 1
            )
        }
    }
}