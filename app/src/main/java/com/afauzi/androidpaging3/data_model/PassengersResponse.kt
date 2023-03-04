package com.afauzi.androidpaging3.data_model

import com.afauzi.androidpaging3.data_model.Passenger

data class PassengersResponse(
    val `data`: List<Passenger>,
    val totalPages: Int,
    val totalPassengers: Int
)
