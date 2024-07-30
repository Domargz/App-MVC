package com.david.myweatherisit.model.dto

data class CityResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)